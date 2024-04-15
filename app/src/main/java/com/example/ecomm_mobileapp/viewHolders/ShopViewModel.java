package com.example.ecomm_mobileapp.viewHolders;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ecomm_mobileapp.database.ShopRepository;
import com.example.ecomm_mobileapp.database.entities.Cart;
import com.example.ecomm_mobileapp.database.entities.Product;

import java.util.List;

public class ShopViewModel extends AndroidViewModel {
    private ShopRepository repository;

    public ShopViewModel (Application application) {
        super(application);
        repository = ShopRepository.getRepository(application);
    }

    public LiveData<List<Product>> getAllProducts() {
        return repository.getAllProducts();
    }

    public LiveData<List<Cart>> getAllCartsByUserId(int userId) {
        return repository.getAllCartsByUserId(userId);
    }

    public LiveData<Product> getProductFromCart(Cart cart) {
        return repository.getProductFromCart(cart);
    }

    public LiveData<Product> getProductByProductId(int productId) {
        return repository.getProductByProductId(productId);
    }

    public void insertProduct(Product product) {repository.insertProduct(product);}



}
