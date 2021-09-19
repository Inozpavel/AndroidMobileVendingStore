package com.example.onlinestore.Presentation.Repository.Abstractions;

import androidx.lifecycle.LiveData;

import com.example.onlinestore.Domain.Model.Product;

import java.util.List;

public interface IProductRepository
{
    <T extends Product> LiveData<List<T>> getAllProducts();
    <T extends Product> void addProduct(T product);
    <T extends Product> void deleteProduct(T product);
}
