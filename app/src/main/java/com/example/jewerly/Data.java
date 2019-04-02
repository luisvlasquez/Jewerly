package com.example.jewerly;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Data {

    private static ArrayList<Order> Orders = new ArrayList<>();

    public static void Save(Order O){
        Orders.add(O);
    }

    public static ArrayList<Order> Get(){
        return Orders;
    }

    public static void Update(CheckBox Signature, EditText TxtSignature, Spinner JewelType,
                              Spinner Material, Spinner Stone, double PriceMaterial, double PriceStone,
                              TextView Price, double TotalPrice){
        if (Signature.isChecked()){
            TxtSignature.setVisibility(View.VISIBLE);
        }else{
            TxtSignature.setVisibility(View.INVISIBLE);
        }



        switch (JewelType.getSelectedItemPosition()){
            // select chain
            case 0:
                switch (Material.getSelectedItemPosition()){
                    case 0:
                        PriceMaterial = 100.000;
                        break;
                    case 1:
                        PriceMaterial = 50.000;
                        break;
                    case 2:
                        PriceMaterial = 150.000;
                        break;

                }

                switch (Stone.getSelectedItemPosition()){

                    case 0:
                        PriceStone = 190.000;
                        break;
                    case 1:
                        PriceStone = 180.000;
                        break;
                    case 2:
                        PriceStone = 150.000;
                        break;
                }
                break;

            // select brazalet
            case 1:
                switch (Material.getSelectedItemPosition()){
                    case 0:
                        PriceMaterial = 50.000;
                        break;
                    case 1:
                        PriceMaterial = 30.000;
                        break;
                    case 2:
                        PriceMaterial = 90.000;
                        break;

                }

                switch (Stone.getSelectedItemPosition()){
                    case 0:
                        PriceStone = 190.000;
                        break;
                    case 1:
                        PriceStone = 180.000;
                        break;
                    case 2:
                        PriceStone = 150.000;
                        break;
                }
                break;
        }


        DecimalFormat nume = new DecimalFormat("#.000");
        TotalPrice = PriceMaterial + PriceStone;
        Price.setText("$COP " + nume.format(TotalPrice));
    }
}