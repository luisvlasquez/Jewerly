package com.example.jewerly;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateOrder extends AppCompatActivity {
    private ArrayList<Order> Orders;
    private Spinner JewelType, Material, Stone;
    private CheckBox Signature;
    private EditText SignatureTxt;
    private Resources Resources;
    private TextView Price;
    private Handler Hand = new Handler();

    private ArrayAdapter<String> Adapter1, Adapter2, Adapter3;
    private String[] Op1;
    private String[] Op2;
    private String[] Op3;
    private double Price1, Price2;

    double TotalPrice = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_order);

        JewelType = (Spinner)findViewById(R.id.SpType);
        Material = (Spinner)findViewById(R.id.SpMaterial);
        Stone = (Spinner)findViewById(R.id.SpStone);

        Signature = (CheckBox)findViewById(R.id.CheckSignature);
        SignatureTxt = (EditText)findViewById(R.id.TxtSignature);

        Price = (TextView)findViewById(R.id.TxtPrice);

        Resources = this.getResources();
        Orders = Data.Get();

        Op1 = this.getResources().getStringArray(R.array.jewel_type);
        Op2 = this.getResources().getStringArray(R.array.materials);
        Op3 = this.getResources().getStringArray(R.array.stones);

        Adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Op1);
        Adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Op2);
        Adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Op3);

        JewelType.setAdapter(Adapter1);
        Material.setAdapter(Adapter2);
        Stone.setAdapter(Adapter3);

        Hand.removeCallbacks(Update);
        Hand.postDelayed(Update,15);
    }

    private Runnable Update = new Runnable() {
        @Override
        public void run() {
            Data.Update(Signature, SignatureTxt, JewelType, Material, Stone, Price1, Price2, Price,TotalPrice);
            Hand.postDelayed(this, 150);
        }
    };


    public void Save(View view){

        String ID, JewelTypeV, MaterialV, StoneV, SignatureV, PriceV;
        ID = Orders.size()+1 +"";
        JewelTypeV = JewelType.getSelectedItem().toString();
        MaterialV = Material.getSelectedItem().toString();
        StoneV = Stone.getSelectedItem().toString();
        SignatureV = SignatureTxt.getText().toString();
        PriceV = Price.getText().toString();

        if (Signature.isChecked()){
            if (TextUtils.isEmpty(SignatureTxt.getText().toString())){
                Toast.makeText(this,R.string.toast_error_signature, Toast.LENGTH_LONG).show();
            }else{
                Order O = new Order(ID,JewelTypeV,MaterialV,StoneV, PriceV);
                O.setSignature(SignatureV);
                O.getPrice();
                O.SaveOrder();
                Toast.makeText(this, R.string.toast_done, Toast.LENGTH_LONG).show();
            }
        } else{

            Order O = new Order(ID,JewelTypeV,MaterialV,StoneV, PriceV);
            O.SaveOrder();
            Toast.makeText(this, R.string.toast_done, Toast.LENGTH_LONG).show();
        }

    }


}

