package com.example.vendingstore.Presentation.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.vendingstore.Domain.Model.Product;
import com.example.vendingstore.Presentation.Repository.UnitOfWork;

import java.util.List;

public class LikedProductsViewModel extends ViewModel
{
    public LiveData<List<Product>> getProducts()
    {
        return UnitOfWork.GetProductRepository().getAll();
    }
}