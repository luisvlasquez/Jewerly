package com.example.jewerly;

public class Order {

    private String ID;
    private String Stone;
    private String Signature;
    private String Price;
    private String jewelType;
    private String Material;


    public Order(String ID, String jewelType, String material, String stone, String Price) {
        this.ID = ID;
        this.jewelType = jewelType;
        this.Price = Price;
        Material = material;
        Stone = stone;

    }

    public String getID() {

        return ID;
    }

    public void setID(String ID) {

        this.ID = ID;
    }

    public String getJewelType() {

        return jewelType;
    }

    public void setJewelType(String jewelType) {
        this.jewelType = jewelType;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public String getStone() {
        return Stone;
    }

    public void setStone(String stone) {
        Stone = stone;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void SaveOrder(){
        Data.Save(this);
    }
}