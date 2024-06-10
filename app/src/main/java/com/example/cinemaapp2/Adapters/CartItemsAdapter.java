package com.example.cinemaapp2.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinemaapp2.R;

public class CartItemsAdapter extends RecyclerView.Adapter<CartItemsAdapter.CartViewHolder> {

    private final int[] cartItems;
    private final Context context;

    public CartItemsAdapter(Context context, int[] cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_item_image, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.imageView.setImageResource(cartItems[position]);
    }

    @Override
    public int getItemCount() {
        return cartItems.length;
    }

    static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cartItemImage);
        }
    }
}
