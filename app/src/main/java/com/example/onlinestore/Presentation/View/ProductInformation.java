package com.example.onlinestore.Presentation.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.onlinestore.Presentation.ViewModel.ProductInformationViewModel;
import com.example.onlinestore.databinding.ProductInformationFragmentBinding;

public class ProductInformation extends Fragment
{
    private ProductInformationViewModel viewModel;
    private ProductInformationFragmentBinding binding;

    public ProductInformation()
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
