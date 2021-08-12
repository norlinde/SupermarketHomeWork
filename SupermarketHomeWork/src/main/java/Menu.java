import controllers.Shop;
import entity.User;
import entity.UserType;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    Shop shop = new Shop();

Scanner scanner = new Scanner(System.in);

    public void start()  {
        System.out.println("Welcome to SUPERMARKET! " +
                "Enter your user type: \n1. Buyer \n2. Owner" +
                "\n4. Exit");

        String userChoice = scanner.nextLine();
        User activeUser = createUser(userChoice);

        if (activeUser == null){
            handleExit();
        }
       shop.setActiveUser(activeUser);

        showUserMenu(activeUser.getUserType());
        userChoice = scanner.nextLine();
        handleMenuChoice(activeUser.getUserType(), userChoice);
    }




    private void handleExit() {
        System.out.println("Enter 1 to exit or 2 to show main menu");
        if (scanner.nextLine().equals("1")){
            System.exit(0);
        }
        start();
    }

    private User createUser(String userChoice) {
        switch (Integer.parseInt(userChoice)) {
            case 1:
                System.out.println("Welcome buyer! Enter your budget: ");
                float budget = Float.parseFloat(scanner.nextLine());
                return new User(UserType.BUYER, budget);
            case 2:
                System.out.println("Welcome Owner!");
                return new User(UserType.OWNER);

            default:
                break;
        }

        return null;
    }

    private void handleMenuChoice(UserType userType, String userChoice)  {
        switch (userType) {
            case OWNER:
                handleOwnerChoice(userChoice);
                break;
            case BUYER:
                handleBuyerChoice(userChoice);
                break;
            default:
                start();
        }
    }


    private void handleBuyerChoice(String userChoice)  {
        switch (userChoice){

            case "1":
                shop.sellProductToUser();
                break;
            case "2":
                shop.viewAllProducts();
                break;
           case "3":
                handleExit();
                break;
            default:
                break;
        }
        showUserMenu(shop.getActiveUser().getUserType());
    }

    private void handleOwnerChoice(String userChoice)  {
        switch (userChoice){
            case "1":
                shop.addProduct();
                break;
            case "2":
                shop.deleteProduct();
                break;
            case "3":
                shop.viewAllProducts();
                break;
            case "4":
                handleExit();
                break;
            default:
                break;
        }
        showUserMenu(shop.getActiveUser().getUserType());
    }


    private void showUserMenu(UserType userType)  {
        switch (userType) {
            case OWNER:
                System.out.println(getOwnerMenu());
                break;
            case BUYER:
                System.out.println(getBuyerMenu());
                break;

            default:
                start();
        }
        String userChoice = scanner.nextLine();
        handleMenuChoice(userType, userChoice);
    }



    private String getBuyerMenu() {
        return "\n Choose one option below:"
                + "\n1. Buy Products"
                + "\n2. View All Products"
                + "\n3. Exit";
    }

    private String getOwnerMenu() {
        return "\n choose one option below:"
                + "\n1. Add Product"
                + "\n2. Remove Product"
                + "\n3. View All Products"
                + "\n4. Exit";
    }
}