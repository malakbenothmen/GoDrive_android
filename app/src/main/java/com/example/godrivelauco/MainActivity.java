package com.example.godrivelauco;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private AdapterCar carAdapter;
    private List<Car> carList;
    private RecyclerView recyclerViewBrand;
    private BrandAdapter brandAdapter;
    private List<Brand> brandList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        recyclerViewBrand= findViewById(R.id.brandRecyclerView);
        recyclerView1= findViewById(R.id.recycleNearCar);
        recyclerView2 = findViewById(R.id.recyclePopularCar);

        recyclerViewBrand.setNestedScrollingEnabled(false);
        recyclerView1.setNestedScrollingEnabled(false);
        recyclerView2.setNestedScrollingEnabled(false);



        recyclerViewBrand.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        initializeBrands();
        brandAdapter = new BrandAdapter(brandList);
        recyclerViewBrand.setAdapter(brandAdapter);


        // Initialize car list
        carList = new ArrayList<>();
        carList.add(new Car("Jaguar F Pace", "Automatic", 4.8, 200, R.drawable.maserati));
        carList.add(new Car("Jaguar F Pace", "Automatic", 3.8, 150, R.drawable.red_car));
        carList.add(new Car("Jaguar F Pace", "Automatic", 4.1, 300, R.drawable.black_car));
        carAdapter = new AdapterCar(carList);
        recyclerView1.setAdapter(carAdapter);
        recyclerView2.setAdapter(carAdapter);

        recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));



    }

    private void initializeBrands() {
        brandList = new ArrayList<>();
        brandList.add(new Brand("BMW", R.drawable.bmw_logo));
        brandList.add(new Brand("Mercedes", R.drawable.mercedes_logo));
        brandList.add(new Brand("Porsche", R.drawable.porsche_logo));
        brandList.add(new Brand("Audi", R.drawable.porsche_logo));
    }
}