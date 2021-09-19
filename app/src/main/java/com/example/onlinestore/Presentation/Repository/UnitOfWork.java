package com.example.onlinestore.Presentation.Repository;

import com.example.onlinestore.Presentation.Repository.Abstractions.IProductRepository;
import com.example.onlinestore.Presentation.Repository.Mock.ProductMockRepository;

public class UnitOfWork
{
    private static IProductRepository productRepository;

    public static void initProductRepository()
    {
        productRepository = new ProductMockRepository();
    }

    public static IProductRepository GetProductRepository()
    {
        if (productRepository == null)
        {
            productRepository = new ProductRepository();
        }
        return productRepository;
    }
}
