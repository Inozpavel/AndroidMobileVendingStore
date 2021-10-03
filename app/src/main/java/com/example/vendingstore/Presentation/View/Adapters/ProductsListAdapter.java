package com.example.vendingstore.Presentation.View.Adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vendingstore.Domain.Model.Product;
import com.example.vendingstore.Presentation.Repository.UnitOfWork;
import com.example.vendingstore.Presentation.ViewModel.ProductInformationViewModel;
import com.example.vendingstore.R;
import com.example.vendingstore.databinding.ProductElementBinding;
import com.google.gson.Gson;

import java.util.List;

public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.ProductViewHolder>
{
    public interface OnProductClickListener
    {
        void onProductClick(Product product);
    }

    private final OnProductClickListener onClickListener;

    private final List<Product> data;

    public ProductsListAdapter(List<Product> data,
                               OnProductClickListener onClickListener)
    {
        this.data = data;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        ProductElementBinding binding = ProductElementBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position)
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
            holder.binding.imageViewProduct.setImageBitmap(bitmap);
        } else
        {
            holder.binding.imageViewProduct.setImageResource(R.drawable.nophoto);
        }
        holder.itemView.setOnClickListener(v ->
                onClickListener.onProductClick(product));

        if (product.getIsLiked())
        {
            holder.binding.likeButton.setImageResource(R.drawable.heart_filled);
        } else
        {
            holder.binding.likeButton.setImageResource(R.drawable.heart);
        }
        ProductInformationViewModel viewModel = new ProductInformationViewModel();
        viewModel.setProduct(product);
        holder.setViewModel(viewModel);

        holder.binding.likeButton.setOnClickListener(v ->
        {
            Product viewModelProduct = holder.viewModel.getProduct();
            viewModelProduct.setIsLiked(!viewModelProduct.getIsLiked());
            if (viewModelProduct.getIsLiked())
            {
                UnitOfWork.GetProductRepository().addOrUpdate(product);
                holder.binding.likeButton.setImageResource(R.drawable.heart_filled);
            } else
            {
                UnitOfWork.GetProductRepository().delete(product);
                holder.binding.likeButton.setImageResource(R.drawable.heart);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder
    {
        ProductElementBinding binding;
        ProductInformationViewModel viewModel;

        public ProductViewHolder(ProductElementBinding binding)
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