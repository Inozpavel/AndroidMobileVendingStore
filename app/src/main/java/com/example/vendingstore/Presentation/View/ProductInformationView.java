package com.example.vendingstore.Presentation.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.vendingstore.Presentation.ViewModel.ProductInformationViewModel;
import com.example.vendingstore.databinding.ProductInformationFragmentBinding;

public class ProductInformationView extends Fragment
{
    private ProductInformationViewModel viewModel;
    private ProductInformationFragmentBinding binding;

    public ProductInformationView()
    {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        binding = ProductInformationFragmentBinding.inflate(getLayoutInflater(), container, false);
        
        viewModel = new ViewModelProvider(this).get(ProductInformationViewModel.class);

        return binding.getRoot();
    }
}
