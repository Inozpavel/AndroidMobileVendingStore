package com.example.onlinestore.Presentation.Repository.Abstractions;

import androidx.lifecycle.LiveData;

import com.example.onlinestore.Domain.Model.Product;

import java.util.List;

public interface ILikedProductRepository
{
    <T extends Product> LiveData<List<T>> getAll();
    <T extends Product> void addOrUpdate(T product);
    <T extends Product> void delete(T product);
    List<Integer> getAllIds();
}
