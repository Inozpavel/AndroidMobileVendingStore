package com.example.onlinestore.Presentation.View.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinestore.Domain.Model.Product;
import com.example.onlinestore.Presentation.ViewModel.ProductInformationViewModel;
import com.example.onlinestore.databinding.ProductLikedElementBinding;

import java.util.List;

public class LikedProductsListAdapter extends RecyclerView.Adapter<LikedProductsListAdapter.LikedProductViewHolder>
{
    private final List<Product> data;

    public LikedProductsListAdapter(List<Product> data)
    {
        this.data = data;
    }

    @NonNull
    @Override
    public LikedProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        ProductLikedElementBinding binding = ProductLikedElementBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new LikedProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LikedProductViewHolder holder, int position)
    {
        Product product = data.get(position);

        holder.binding.productName.setText(product.getProductName());
        holder.binding.productDescription.setText(product.getDescription());
        holder.binding.productPrice.setText(String.valueOf(product.getPrice()));

        holder.binding.isLiked.setText(String.valueOf(product.getIsLiked()));

        ProductInformationViewModel viewModel = new ProductInformationViewModel();
        viewModel.setProduct(product);
        holder.setViewModel(viewModel);
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    static class LikedProductViewHolder extends RecyclerView.ViewHolder
    {
        ProductLikedElementBinding binding;
        ProductInformationViewModel viewModel;

        public LikedProductViewHolder(ProductLikedElementBinding binding)
        {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void setViewModel(ProductInformationViewModel viewModel)
        {
            this.viewModel = viewModel;
        }
    }
}