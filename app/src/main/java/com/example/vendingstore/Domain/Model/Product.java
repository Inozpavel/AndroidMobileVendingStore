package com.example.vendingstore.Domain.Model;

import androidx.annotation.NonNull;

public class Product
{
    @NonNull
    private String productName = "Продукт";
    private double price;
    private String description;
    private boolean isLiked;
    private String image;
    
    public Product()
    {
    }

    public Product(@NonNull String productName, double price, String description, boolean isLiked)
    {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.isLiked = isLiked;
    }

    //region getters and setters
    @NonNull
    public String getProductName()
    {
        return productName;
    }

    public void setProductName(@NonNull String productName)
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

    public boolean getIsLiked()
    {
        return isLiked;
    }

    public void setIsLiked(boolean isLiked)
    {
        this.isLiked = isLiked;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    //endregion
}
