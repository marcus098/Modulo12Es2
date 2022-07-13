import java.util.Comparator;

public class Frutta{
    private String name;
    private int quantity;
    private Colore color;
    private double price;


    public Frutta(String name, int quantity, Colore color, double price){
        this.name = name;
        this.quantity = quantity;
        this.color = color;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void removeQuantity(int quantity){
        this.quantity -= quantity;
    }

    public Colore getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Frutta{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ""+
                '}';
    }
}
