package be.intecbrussel.Opdrachten;

public class ShoePair {
    private String brand;
    private boolean complete;
    private String color;
    private int size;
    private double price;

    public ShoePair(String brand, boolean complete, String color, int size, double price) {
        this.brand = brand;
        this.complete = complete;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public boolean isComplete() {
        return complete;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Shoe Pair: " +
                "\nBrand ->" + brand +
                "\nComplete -> " + (complete ? "Yes" : "No") +
                "\nColor -> " + color +
                "\nSize -> " + size +
                "\nPrice -> " + price + "€\n";
    }
}
