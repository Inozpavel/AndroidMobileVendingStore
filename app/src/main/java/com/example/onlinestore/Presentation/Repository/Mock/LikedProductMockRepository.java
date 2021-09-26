package com.example.onlinestore.Presentation.Repository.Mock;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.onlinestore.Domain.Model.Product;
import com.example.onlinestore.Presentation.Repository.Abstractions.ILikedProductRepository;
import com.example.onlinestore.Presentation.Repository.Model.ProductDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LikedProductMockRepository implements ILikedProductRepository
{
    private final MutableLiveData<List<Product>> data;
    private final List<Product> products;

    private final int startId = 0;
    private final int endId = 4;

    public LikedProductMockRepository()
    {
        products = new ArrayList<>();

        Random random = new Random();
        for (int i = startId; i < endId; i++)
        {
            products.add(new ProductDTO(i * 2, "Товар " + i, random.nextDouble() * 1000, null, true));
        }
        data = new MutableLiveData<>(products);
    }

    @Override
    public LiveData<List<Product>> getAll()
    {
        return data;
    }

    @Override
    public <T extends Product> void addOrUpdate(T product)
    {
        products.add(product);
        data.setValue(products);
    }

    @Override
    public <T extends Product> void delete(T product)
    {
        products.remove(product);
        data.setValue(products);
    }

    @Override
    public List<Integer> getAllIds()
    {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = startId; i < endId; i++)
        {
            list.add(i * 2);
        }
        return list;
    }
}
