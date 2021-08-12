package repository;

import database.DBHandler;
import entity.Product;

import java.sql.*;
import java.util.ArrayList;

public class BuyerRepository {
    private DBHandler dbHandler = new DBHandler();



    public Product findProductById(int id) throws SQLException {
        Product product;

        Statement statement = dbHandler.getConnection().createStatement();
        String query = "SELECT * FROM product WHERE id =" + id + " LIMIT 1";

        ResultSet results = statement.executeQuery(query);

        results.next();
        product = new Product(
                results.getInt("id"),
                results.getString("productName"),
                results.getFloat("price"),
                results.getInt("quantity")
        );

        statement.close();

        return product;
    }


    }







