package com.example.onlinestore.Presentation.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.onlinestore.databinding.ProductInformationFragmentBinding;

public class ProductInformation extends Fragment
{
    private ProductInformationFragmentBinding binding;

    public ProductInformation()
    {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        binding = ProductInformationFragmentBinding.inflate(getLayoutInflater(), container, false);


        return binding.getRoot();
    }
}
