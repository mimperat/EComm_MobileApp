package com.example.ecomm_mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ecomm_mobileapp.database.ShopDatabase;
import com.example.ecomm_mobileapp.database.ShopRepository;
import com.example.ecomm_mobileapp.database.UserDAO;
import com.example.ecomm_mobileapp.database.entities.User;
import com.example.ecomm_mobileapp.databinding.ActivityMainBinding;
import com.example.ecomm_mobileapp.viewHolders.ShopAdapter;
import com.example.ecomm_mobileapp.viewHolders.ShopViewHolder;
import com.example.ecomm_mobileapp.viewHolders.ShopViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ShopRepository repository;

    private ShopViewModel shopViewModel;
//    private ShopDatabase db;
    public static final String TAG = "CRT_SHOP";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
        Log.i(MainActivity.TAG, "Hello World");

        repository = ShopRepository.getRepository(getApplication());
        shopViewModel = new ViewModelProvider(this).get(ShopViewModel.class);

        RecyclerView recyclerView = binding.mainRecyclerviewItems;
        final ShopAdapter adapter = new ShopAdapter(new ShopAdapter.ShopDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        shopViewModel.getAllProducts().observe(this, products -> {
            adapter.submitList(products);
        });





        // TODO: finish adding holder, adapter, and ... for our Shop Class
        // TODO: Learn how to implement multiple Recycler Views.

        // TODO: create class and intent factory for layout Login
        Button btnLogout = (Button)findViewById(R.id.main_header_logout_button);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "You clicked the Logout button", Toast.LENGTH_SHORT).show();
            }
        });

        // TODO: create class and intent factory for layout ViewCart
        Button btnViewCart = (Button)findViewById(R.id.main_button_viewcart);
        btnViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked the ViewCart button", Toast.LENGTH_LONG).show();
            }
        });




    }


}