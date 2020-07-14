package com.example.bakery;

public class Products {
    private String productName;
    private int available;

    public Products(String productName, int available, int imageid, String price) {
        this.productName = productName;
        this.available = available;
        this.imageid = imageid;
        this.price = price;
    }

    private int imageid;
    private String price;

    public String getProductName() {
        return productName;
    }

    public int getAvailable() {
        return available;
    }

    public int getImageid() {
        return imageid;
    }

    public String getPrice() {
        return price;
    }





}
