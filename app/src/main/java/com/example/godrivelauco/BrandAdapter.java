package com.example.godrivelauco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.BrandViewHolder> {
    private List<Brand> brandList;
    private Context context;

    public BrandAdapter(List<Brand> brandList) {
        this.brandList = brandList;
    }

    @NonNull
    @Override
    public BrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.brand_row, parent, false);
        return new BrandViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandViewHolder holder, int position) {
        Brand brand = brandList.get(position);
        holder.brandName.setText(brand.getName());

        int resourceId = context.getResources().getIdentifier(
                brand.getLogoUrl(),
                "drawable",
                context.getPackageName()
        );

        // Charger l'image avec Glide
        Glide.with(context)
                .load(brand.getLogoUrl())
                .into(holder.brandLogo);
    }

    @Override
    public int getItemCount() {
        return brandList.size();
    }

    static class BrandViewHolder extends RecyclerView.ViewHolder {
        ImageView brandLogo;
        TextView brandName;

        BrandViewHolder(View itemView) {
            super(itemView);
            brandLogo = itemView.findViewById(R.id.brandLogo);
            brandName = itemView.findViewById(R.id.brandName);
        }
    }
}