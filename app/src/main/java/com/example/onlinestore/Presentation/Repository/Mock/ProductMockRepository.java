package com.example.onlinestore.Presentation.Repository.Mock;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.onlinestore.Domain.Model.Product;
import com.example.onlinestore.Presentation.Repository.Abstractions.IProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductMockRepository implements IProductRepository
{
    private MutableLiveData<List<Product>> data;
    private List<Product> products;

    public ProductMockRepository()
    {
        products = new ArrayList<>();

        Random random = new Random();
        products.add(new Product("Товар 1", random.nextDouble(), null));

        data = new MutableLiveData<>(products);
    }

    @Override
    public LiveData<List<Product>> getAllProducts()
    {
        return data;
    }

    @Override
    public <T extends Product> void addProduct(T product)
    {
        products.add(product);
        data.setValue(products);
    }

    @Override
    public <T extends Product> void deleteProduct(T product)
    {
        products.remove(product);
        data.setValue(products);
    }
}
