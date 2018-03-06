package entity;

public class Topping {

    private String toppingType;
    private int price;

    public Topping(String toppingType, int price) {
        this.toppingType = toppingType;
        this.price = price;
    }

    public String getToppingType() {
        return toppingType;
    }

    public void setToppingType(String toppingType) {
        this.toppingType = toppingType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
