package com.example.godrivelauco;

public class Car {
    static int count = 0 ;
    private int id;
    private String name;
    private String transmission;
    private double rating;
    private int pricePerDay;
    private int imageResourceId;
    private boolean isFavorite;

    public Car(String name, String transmission, double rating, int pricePerDay, int imageResourceId) {
        this.id=count;
        count++;
        this.name = name;
        this.transmission = transmission;
        this.rating = rating;
        this.pricePerDay = pricePerDay;
        this.imageResourceId = imageResourceId;
        this.isFavorite = false;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTransmission() {
        return transmission;
    }

    public double getRating() {
        return rating;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public boolean isFavorite() {
        return isFavorite;
    }
}