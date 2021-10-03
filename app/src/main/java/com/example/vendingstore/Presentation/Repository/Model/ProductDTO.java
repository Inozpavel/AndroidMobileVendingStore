package com.example.vendingstore.Presentation.Repository.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.vendingstore.Domain.Model.Product;

@Entity(tableName = "liked_products")
public class ProductDTO extends Product
{
    @PrimaryKey
    @ColumnInfo
    private int id;

    public ProductDTO(int id, String productName, double price, String description, boolean isLiked)
    {
        super(productName, price, description, isLiked);
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
