package com.example.godrivelauco;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.BrandViewHolder> {
    private List<Brand> brandList;




    public BrandAdapter(List<Brand> brandList) {
        this.brandList = brandList;

    }

    @NonNull
    @Override
    public BrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.brand_row, parent, false);
        return new BrandViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandViewHolder holder, int position) {
        Brand brand = brandList.get(position);
        holder.brandLogo.setImageResource(brand.getLogoResource());
        holder.brandName.setText(brand.getName());


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