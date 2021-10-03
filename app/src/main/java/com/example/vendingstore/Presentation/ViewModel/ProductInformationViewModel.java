package com.example.vendingstore.Presentation.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.vendingstore.Domain.Model.Product;

public class ProductInformationViewModel extends ViewModel
{
    private Product product;

    // region getters and setters
    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }
    // endregion
}
