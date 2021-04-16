package com.NWACoders.mkOne.services;

import com.NWACoders.mkOne.exceptions.ProductNotFoundException;
import com.NWACoders.mkOne.models.Products;
import com.NWACoders.mkOne.repos.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

//This is the service that will communicate with the front end
@Service
public class ProductServices {

    //importing the repository to work with
    private final ProductRepo productRepo;

    //initializing the constructor
    public ProductServices(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    //Creating a method to store products in the database
    public Products addNewProduct(Products products) {
        return productRepo.save(products);
    }

    //Creating a function that retrieves all products from the database
    public Iterable<Products> displayAllProducts() {
        return productRepo.findAll();
    }

    //Updating/Editing the information inside of the database
    public Products updateExistingProduct(Products products){
        return productRepo.save(products);
    }

    //Method to delete existing products
    public void deletingExistingProducts(int id){
        productRepo.deleteById(id);
    }


    //Method for finding specific product by id
    public Products findProductById(int id){
        return productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("the product id of: " + id + " was not found."));
    }

}
