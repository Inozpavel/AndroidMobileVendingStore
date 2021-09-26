package com.example.onlinestore.Presentation.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.onlinestore.Domain.Model.Product;
import com.example.onlinestore.Presentation.View.Adapters.ProductsListAdapter;
import com.example.onlinestore.Presentation.ViewModel.AllProductsViewModel;
import com.example.onlinestore.R;
import com.example.onlinestore.databinding.AllProductsFragmentBinding;

import java.util.List;

public class AllProducts extends Fragment
{
    private AllProductsViewModel viewModel;
    private AllProductsFragmentBinding binding;

    public AllProducts()
    {
    }

    private static void onClick(View x)
    {
        NavController a = Navigation.findNavController(x);
        a.navigate(R.id.navigation_product_information);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        binding = AllProductsFragmentBinding.inflate(inflater, container, false);
        binding.buttonShowAllProducts.setOnClickListener(AllProducts::onClick);
        binding.productListRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel = new ViewModelProvider(this).get(AllProductsViewModel.class);

        ProductsListAdapter.OnProductClickListener productClickListener = (product) ->
                Navigation.findNavController(binding.getRoot()).navigate(R.id.navigation_product_information);

        viewModel.getProducts().observe(getViewLifecycleOwner(),
                (List<Product> productsList) ->
                        binding.productListRecycler.setAdapter(new ProductsListAdapter(
                                productsList,
                                productClickListener)));

        return binding.getRoot();
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}