package com.example.vendingstore.Presentation.Repository;

import android.app.Application;

import com.example.vendingstore.Presentation.Repository.Abstractions.ILikedProductRepository;
import com.example.vendingstore.Presentation.Repository.Mock.LikedProductMockRepository;

public class UnitOfWork
{
    private static ILikedProductRepository productRepository;

    public static void initProductRepository(Application application)
    {
        productRepository = new LikedProductRepository(application);
    }

    public static ILikedProductRepository GetProductRepository()
    {
        if (productRepository == null)
        {
            productRepository = new LikedProductMockRepository();
        }
        return productRepository;
    }
}
