package entity;

public class Sale {

    private final int productId;
    private final float total;
    private final int quantity;

    public Sale(int productId, float total, int quantity) {
        this.productId = productId;
        this.total = total;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public float getTotal() {
        return total;
    }

    public int getQuantity() {
        return quantity;
    }
}



