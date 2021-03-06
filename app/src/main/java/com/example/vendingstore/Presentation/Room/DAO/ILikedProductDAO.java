package com.example.vendingstore.Presentation.Room.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.vendingstore.Presentation.Repository.Model.ProductDTO;

import java.util.List;

@Dao
public interface ILikedProductDAO
{
    @Insert
    void add(ProductDTO product);

    @Update
    void update(ProductDTO product);

    @Query("DELETE FROM liked_products WHERE id=:id")
    void deleteById(int id);

    @Query("SELECT * FROM liked_products")
    LiveData<List<ProductDTO>> getAll();

    @Query("SELECT * FROM liked_products WHERE id=:id")
    ProductDTO getById(int id);

    @Query("SELECT id FROM liked_products")
    LiveData<List<Integer>> getAllIds();
}
