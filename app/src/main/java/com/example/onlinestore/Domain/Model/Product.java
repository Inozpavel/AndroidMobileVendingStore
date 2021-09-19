package com.example.onlinestore.Domain.Model;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class Product
{
    private String productName;
    private double price;
    private String description;
    private ArrayList<Bitmap> images = new ArrayList<>();

    public Product(String productName, double price, String description)
    {
        this.productName = productName;
        this.price = price;
        this.description = description;
    }

    //region getters and setters
    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public ArrayList<Bitmap> getImages()
    {
        return images;
    }

    public void setImages(ArrayList<Bitmap> images)
    {
        this.images = images;
    }
    //endregion
}
