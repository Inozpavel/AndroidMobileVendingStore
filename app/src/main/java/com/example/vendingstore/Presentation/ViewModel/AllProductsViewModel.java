package com.example.vendingstore.Presentation.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vendingstore.Domain.Model.Product;
import com.example.vendingstore.Presentation.Repository.Model.ProductDTO;
import com.example.vendingstore.Presentation.Repository.UnitOfWork;

import java.util.ArrayList;
import java.util.List;

public class AllProductsViewModel extends ViewModel
{
    private List<Product> products;

    private MutableLiveData<List<Product>> data;

    public AllProductsViewModel()
    {
        products = new ArrayList<>();

        List<Integer> existingProducts = UnitOfWork.GetProductRepository().getAllIds();
        for (int i = 0; i < 10; i++)
        {
            ProductDTO product = new ProductDTO(i, "Товар № " + i, (i + 1) * 100, null, false);
            product.setIsLiked(existingProducts.stream().anyMatch(x -> x == product.getId()));
            products.add(product);
        }

        data = new MutableLiveData<>(products);
    }

    public LiveData<List<Product>> getProducts()
    {
        return data;
    }
    
    public void setIsLiked(int index, boolean isLiked) {
        products.get(index).setIsLiked(isLiked);
        data.setValue(products);
    }
}
