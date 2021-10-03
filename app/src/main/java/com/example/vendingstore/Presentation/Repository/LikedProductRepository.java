package com.example.vendingstore.Presentation.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.vendingstore.Domain.Model.Product;
import com.example.vendingstore.Presentation.Repository.Abstractions.ILikedProductRepository;
import com.example.vendingstore.Presentation.Repository.Model.ProductDTO;
import com.example.vendingstore.Presentation.Room.DAO.ILikedProductDAO;
import com.example.vendingstore.Presentation.Room.VendingDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class LikedProductRepository implements ILikedProductRepository
{
    private final ExecutorService _databaseWriteExecutor;
    private final ILikedProductDAO productDAO;

    public LikedProductRepository(Application application)
    {
        VendingDatabase database = VendingDatabase.getDatabase(application);
        _databaseWriteExecutor = VendingDatabase.getDatabaseWriteExecutor();
        productDAO = database.productDao();
    }

    public LiveData<List<ProductDTO>> getAll()
    {
        return productDAO.getAll();
    }

    @Override
    public <T extends Product> void addOrUpdate(T product)
    {
        product.setIsLiked(true);
        ProductDTO productDTO = (ProductDTO) product;

        ProductDTO existingProduct = productDAO.getById(productDTO.getId());
        if (existingProduct == null)
        {
            _databaseWriteExecutor.execute(() ->
                    productDAO.add((ProductDTO) product));
        } else
        {
            _databaseWriteExecutor.execute(() ->
                    productDAO.update((ProductDTO) product));
        }
    }

    @Override
    public <T extends Product> void delete(T product)
    {
        _databaseWriteExecutor.execute(() ->
                {
                    ProductDTO productDTO = (ProductDTO) product;
                    productDAO.deleteById(productDTO.getId());
                }
        );
    }

    @Override
    public List<Integer> getAllIds()
    {
        return productDAO.getAllIds();
    }
}
