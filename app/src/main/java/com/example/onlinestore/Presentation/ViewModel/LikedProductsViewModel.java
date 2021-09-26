package com.example.onlinestore.Presentation.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.onlinestore.Domain.Model.Product;
import com.example.onlinestore.Presentation.Repository.UnitOfWork;

import java.util.List;

public class LikedProductsViewModel extends ViewModel
{
    public LiveData<List<Product>> getProducts()
    {
        return UnitOfWork.GetProductRepository().getAll();
    }
}