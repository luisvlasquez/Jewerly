package com.example.jewerly;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewOrder extends AppCompatActivity {
    private ListView LV;
    private ArrayList<Order> Orders;
    private ArrayList<String> OrderNames;
    private Intent In;
    private TextView TxtNoResults;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_order);

        LV = (ListView)findViewById(R.id.LVOrders);
        TxtNoResults = (TextView)findViewById(R.id.TxtNoResults);
        Orders = Data.Get();
        OrderNames = new ArrayList<String>();

        TxtNoResults.setVisibility(View.VISIBLE);
        LV.setVisibility(View.INVISIBLE);

        if (Orders.size() > 0){
            LV.setVisibility(View.VISIBLE);
            TxtNoResults.setVisibility(View.INVISIBLE);

            for (int i = 0; i < Orders.size(); i++){
                OrderNames.add(Orders.get(i).getJewelType() + "\n" + Orders.get(i).getMaterial() + " - " + Orders.get(i).getStone());
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, OrderNames);
        LV.setAdapter(adapter);

        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                In = new Intent(ViewOrder.this, OrdDetail.class);
                In.putExtra("position", position);
                startActivity(In);
            }
        });

    }
}