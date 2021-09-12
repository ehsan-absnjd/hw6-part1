package shop.entities;

public class Product {
    private static int idGen=1;
    public static enum Type{ ELECTRIC,SHOE,READABLE }
    private int id=idGen++;
    private Type type;
    private int price;
    private int quantity;
    private int uncommitedQuantity;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type=" + type +
                ", price=" + price +
                ", quantity in stock=" + quantity +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getUncommitedQuantity() {
        return uncommitedQuantity;
    }

    public void setUncommitedQuantity(int uncommitedQuantity) {
        this.uncommitedQuantity = uncommitedQuantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Type getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
