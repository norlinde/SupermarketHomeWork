package repository;

import database.DBHandler;
import entity.Product;
import entity.Sale;

import java.sql.*;
import java.util.ArrayList;

public class OwnerRepository {
    private DBHandler dbHandler = new DBHandler();


    public void addProduct(Product product) throws SQLException {
        Connection connection = dbHandler.getConnection();
        String query = "INSERT INTO product (productName, price, quantity) VALUES(?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setFloat(2, product.getPrice());
        preparedStatement.setInt(3, product.getQuantity());
        preparedStatement.execute();
        preparedStatement.close();
    }

    public void delete(Product product) throws SQLException {
        Connection connection = dbHandler.getConnection();
        String query = "DELETE FROM Product WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, product.getId());
        preparedStatement.execute();
        preparedStatement.close();
    }

    public ArrayList<Product> viewAllProducts() throws SQLException {
        Statement statement = dbHandler.getConnection().createStatement();
        String query = "SELECT * FROM product";
        ResultSet results = statement.executeQuery(query);

        ArrayList<Product> products = new ArrayList<Product>();

        while (results.next()) {
            int id = results.getInt("id");
            String productName = results.getString("productName");
            float price = results.getFloat("price");
            int quantity = results.getInt("quantity");


            products.add(new Product(id, productName, price, quantity));
        }

        statement.close();

        return products;
    }


    public void updateProductQuantity( int id, int quantity) throws SQLException {


        Connection connection = dbHandler.getConnection();
        String query = "UPDATE product SET quantity = product.quantity - ? WHERE product.id = ?";


        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(2, quantity);
        preparedStatement.setInt(1, id);

        preparedStatement.close();



    }



    }
