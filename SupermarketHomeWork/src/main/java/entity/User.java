package entity;

public class User {
    private int id;
    private  UserType userType;
    private float budget;


    public User() {

    }

    public UserType getUserType() {
        return userType;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) { this.budget = budget; }



    public User(UserType userType, float budget) {
        this.userType = userType;
        this.budget = budget;

    }

    public User(UserType userType){
        this.userType = userType;
    }
}


   