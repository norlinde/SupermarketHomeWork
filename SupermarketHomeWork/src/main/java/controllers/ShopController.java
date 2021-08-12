package controllers;

import entity.Product;
import entity.Sale;
import entity.User;
import repository.BuyerRepository;
import repository.OwnerRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class ShopController {

    OwnerRepository ownerRepository = new OwnerRepository();


    public String addProduct(Product product) {
        try {

            ownerRepository.addProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error with adding product";
        }
        return "Product added successfully";
    }

    public String delete(Product product) {

        try {
            ownerRepository.delete(product);
        } catch (SQLException e) {
            e.printStackTrace();
            return "error with deleting product";
        }
        return "Product with ID " + product.id + " deleted successfully";
    }

    public ArrayList<Product> viewAllProducts() {
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            products = ownerRepository.viewAllProducts();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return products;
    }


    public void updateProductQuantity(int id, int quantity) {
        try{
            ownerRepository.updateProductQuantity(id, quantity);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }


    }
}


