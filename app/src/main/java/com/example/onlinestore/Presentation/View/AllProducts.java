package com.example.onlinestore.Presentation.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.onlinestore.R;
import com.example.onlinestore.databinding.AllProductsFragmentBinding;

public class AllProducts extends Fragment
{

    private AllProductsFragmentBinding binding;

    public AllProducts()
    {
    }

    private static void onClick(View x)
    {
        NavController a = Navigation.findNavController(x);
        a.navigate(R.id.productInformation);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        binding = AllProductsFragmentBinding.inflate(getLayoutInflater(), container, false);
        binding.buttonShowAllProducts.setOnClickListener(AllProducts::onClick);
     
        return binding.getRoot();
    }

}