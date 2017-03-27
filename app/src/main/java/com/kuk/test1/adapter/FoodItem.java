package com.kuk.test1.adapter;

/**
 * Created by KUK on 1/3/2560.
 */

public class FoodItem {
    String name;
    String image;
    int price;

    public FoodItem(String n,int p,String i){
        setName(n);
        setImage(i);
        setPrice(p);
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
