package com.example.onlinestore.Domain.Model;

public class Product
{
    private String productName;
    private double price;
    private String description;
    private boolean isLiked;
    
    public Product()
    {
    }

    public Product(String productName, double price, String description, boolean isLiked)
    {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.isLiked = isLiked;
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

    public boolean getIsLiked()
    {
        return isLiked;
    }

    public void setIsLiked(boolean isLiked)
    {
        this.isLiked = isLiked;
    }
    //endregion
}
