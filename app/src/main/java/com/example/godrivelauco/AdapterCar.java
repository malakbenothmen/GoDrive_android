package com.example.godrivelauco;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterCar extends RecyclerView.Adapter<AdapterCar.MyViewHolder> {

    private List<Car> carsList ;

    public AdapterCar(List<Car> carsList) {
        this.carsList = carsList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_home_row, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Car c= carsList.get(position);
        holder.carName.setText(c.getName());
        holder.carImage.setImageResource(c.getImageResourceId());
        holder.rating.setText(String.format("%.1f", c.getRating()));
        holder.price.setText(String.valueOf(c.getPricePerDay()));
        holder.transmission.setText(c.getTransmission());


    }

    @Override
    public int getItemCount() {
        return this.carsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView carName, transmission, rating, price;
        public ImageView carImage;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            carName = itemView.findViewById(R.id.carName);
            carImage = itemView.findViewById(R.id.carImage);
            transmission = itemView.findViewById(R.id.transmission);
            price = itemView.findViewById(R.id.price);
            rating = itemView.findViewById(R.id.rating);

        }
    }

}
