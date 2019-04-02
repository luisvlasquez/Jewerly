package com.example.jewerly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView Lv;
    private String Opc[];
    private Resources Resources;
    private Intent In;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lv = (ListView)findViewById(R.id.Options);
        Resources = this.getResources();
        Opc = Resources.getStringArray(R.array.Menu);
        ArrayAdapter<String> Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Opc);
        Lv.setAdapter(Adapter);

        Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        In = new Intent(MainActivity.this, CreateOrder.class);
                        startActivity(In);
                        break;

                    case 1:
                        In = new Intent(MainActivity.this, ViewOrder.class);
                        startActivity(In);
                        break;
                }
            }
        });


    }
}