package com.example.vendingstore.Presentation.Repository.Abstractions;

import androidx.lifecycle.LiveData;

import com.example.vendingstore.Domain.Model.Product;

import java.util.List;

public interface ILikedProductRepository
{
    <T extends Product> LiveData<List<T>> getAll();
    <T extends Product> void addOrUpdate(T product);
    <T extends Product> void delete(T product);
    List<Integer> getAllIds();
}
