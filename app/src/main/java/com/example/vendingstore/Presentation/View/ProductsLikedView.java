package com.example.vendingstore.Presentation.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.vendingstore.Domain.Model.Product;
import com.example.vendingstore.Presentation.View.Adapters.LikedProductsListAdapter;
import com.example.vendingstore.Presentation.ViewModel.LikedProductsViewModel;
import com.example.vendingstore.databinding.FragmentProductsLikedBinding;

import java.util.List;

public class ProductsLikedView extends Fragment
{
    private FragmentProductsLikedBinding binding;
    private LikedProductsViewModel viewModel;
    
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentProductsLikedBinding.inflate(getLayoutInflater(), container, false);


        binding.productListRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel = new ViewModelProvider(this).get(LikedProductsViewModel.class);

        viewModel.getProducts().observe(getViewLifecycleOwner(),
                (List<Product> productsList) ->
                        binding.productListRecycler.setAdapter(new LikedProductsListAdapter(
                                productsList)));
        
        return binding.getRoot();
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}
