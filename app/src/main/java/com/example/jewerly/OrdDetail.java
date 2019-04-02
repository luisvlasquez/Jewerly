package com.example.jewerly;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class OrdDetail extends AppCompatActivity {

    private Intent In;
    private ArrayList<Order> Orders;
    private TextView TxtOrderTye, TxtPrice, TxtMaterial, TxtSignature, TxtSignatureCheck, TxtCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ord_detail);

        In = getIntent();
        Orders = Data.Get();

        int Position = In.getIntExtra("position", 0);

        TxtOrderTye = (TextView)findViewById(R.id.TxtOrderType);
        TxtPrice = (TextView)findViewById(R.id.TxtPrice);
        TxtMaterial = (TextView) findViewById(R.id.TxtMaterial);
        TxtSignature = (TextView)findViewById(R.id.TxtStone);
        TxtSignatureCheck = (TextView)findViewById(R.id.TxtSignature);
        TxtCheckbox = (TextView)findViewById(R.id.Text1);

        loadData(Orders.get(Position));

    }

    private void loadData(Order Order){
        TxtOrderTye.setText(Order.getJewelType());
        TxtPrice.setText(Order.getPrice());
        TxtMaterial.setText(Order.getMaterial());
        TxtSignature.setText(Order.getStone());
        TxtSignatureCheck.setText(Order.getSignature());

        if (TextUtils.isEmpty(Order.getSignature())){
            TxtCheckbox.setVisibility(View.INVISIBLE);
            TxtSignatureCheck.setVisibility(View.INVISIBLE);
        }else{
            TxtCheckbox.setVisibility(View.VISIBLE);
            TxtSignatureCheck.setVisibility(View.VISIBLE);
        }

    }
}