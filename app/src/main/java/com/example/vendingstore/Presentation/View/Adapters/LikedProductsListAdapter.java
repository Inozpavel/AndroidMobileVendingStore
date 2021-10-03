package com.example.vendingstore.Presentation.View.Adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vendingstore.Domain.Model.Product;
import com.example.vendingstore.Presentation.ViewModel.ProductInformationViewModel;
import com.example.vendingstore.R;
import com.example.vendingstore.databinding.ProductLikedElementBinding;
import com.google.gson.Gson;

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

        String image = product.getImage();
        if (image != null)
        {
            Gson gson = new Gson();
            byte[] bytes = gson.fromJson(image, byte[].class);
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            holder.binding.imageViewLikedProduct.setImageBitmap(bitmap);
        } else
        {
            holder.binding.imageViewLikedProduct.setImageResource(R.drawable.nophoto);
        }
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