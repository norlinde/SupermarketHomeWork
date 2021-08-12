package controllers;
import entity.Product;
import entity.Sale;
import entity.User;
import repository.BuyerRepository;
import repository.OwnerRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {

    Scanner scanner = new Scanner(System.in);
    ShopController shopController = new ShopController();
    OwnerRepository ownerRepository = new OwnerRepository();
    Product product = new Product();
    ArrayList<Product> products = new ArrayList<>();
    User user = new User();
    ArrayList<Sale> saleHistory = new ArrayList<>();


    public void setActiveUser(User activeUser) {
        this.user = activeUser;
    }

    public User getActiveUser() {
        return this.user;
    }

    public void addProduct() {
        Product newProduct = new Product();
        System.out.println("Add a new product");

        System.out.println("Enter product's name:");
        newProduct.setProductName(scanner.nextLine());

        System.out.println("Enter price:");
        newProduct.setPrice(Float.parseFloat(scanner.nextLine()));

        System.out.println("Enter quantity:");
        newProduct.setQuantity(Integer.parseInt(scanner.nextLine()));

        System.out.println(shopController.addProduct(newProduct));
    }

    public void deleteProduct() {
        Product deleteProduct = new Product();
        System.out.println("Delete a Product");

        System.out.println("Enter product's ID:");
        deleteProduct.id = Integer.parseInt(scanner.nextLine());

        System.out.println(shopController.delete(deleteProduct));
    }

    public void viewAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products = shopController.viewAllProducts();
        System.out.println("All PRODUCTS:\n");
        System.out.println("ID\t\t Product Name\t\t Price \t\t\t\tQuantity \n");
        for (Product currentProduct : products) {
            System.out.println
                    (currentProduct.id + "\t\t\t" + currentProduct.getProductName() + "\t\t\t"
                            + currentProduct.getPrice() + "\t\t\t\t" + currentProduct.getQuantity());
        }
    }

    private void addSalesHistory(int productId, int quantity, float total) {
        this.saleHistory.add(new Sale(productId, total, quantity));
    }

    public void viewSalesHistory() {
        System.out.println("NAME | \tQUANTITY | \tAMOUNT");
        for (Sale sale : saleHistory) {
            Product product = products.get(sale.getProductId());
            System.out.println(product.getProductName() + "\t| " + sale.getQuantity()
                    + "\t| " + sale.getTotal());
        }
    }

    private Product findProductById(int productId) {
        products = shopController.viewAllProducts();
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }




    private boolean userCanBuyProduct(int quantity, double budget) throws Exception {
        if (product == null) throw new Exception("Invalid product selection");
        if (budget < product.getPrice()) throw new Exception("You do not have enough money to buy the product!");
        if (quantity<product.getQuantity()) throw new Exception("Not enough products left in the market");
        return true;
    }

    private void showSuccessMessage(String message) {
        System.out.println(message + " Successfully!");
    }

    private void showFailedMessage(String message) {
        System.out.println("Failed! - " + message);
    }

    public String buyProduct ( Integer productId,Integer productQuantity){

       Product productToSell = findProductById(productId);

       if(productToSell == null){ return "product not found"; }
       if(productToSell.getQuantity() < productQuantity) { return "not enough items to fulfill your order";}

       float userBalance = user.getBudget();
       float totalCostOfPurchase = productToSell.getPrice() * productQuantity;

       if(userBalance < totalCostOfPurchase ) { return "not enough money on users account";}

       user.setBudget(userBalance - totalCostOfPurchase);
       shopController.updateProductQuantity
               (productId, productToSell.getQuantity() - productQuantity);



       return "Product purchase successful" ;
   }


    public void sellProductToUser() {
     System.out.println("Enter ID for the product you want to buy:");
    int  productId = scanner.nextInt();
    System.out.println("Enter quantity of the product:");
    int   productQuantity = scanner.nextInt();

        System.out.println(buyProduct( productId,  productQuantity));
    }}














/*
    public void sellProduct()  {


      System.out.println("Enter ID for the product you want to buy:");
      int productId = scanner.nextInt();

      System.out.println("Enter quantity of the product:");

      int productQuantity = scanner.nextInt();
        productQuantity = shopController.updateProductQuantity(productQuantity);


      Product product = findProductById(productId);
      boolean userCanBuyProduct = false;


        try {
            userCanBuyProduct = userCanBuyProduct(product.getQuantity(), user.getBudget());
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        if (userCanBuyProduct) {
            product.setQuantity(product.getQuantity() -1);
            addSalesHistory(product.getId(), 1, product.getPrice());
            updateUserBalance(user.getBudget() -(productQuantity * product.getPrice()));
            updateProductQuantity(productQuantity -this.product.getQuantity());


            showSuccessMessage("Product Purchased");

            return ;

        }
        showFailedMessage("Unable to complete product purchase!");*/




