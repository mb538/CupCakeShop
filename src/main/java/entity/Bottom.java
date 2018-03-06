package entity;

public class Bottom {
    
    private String bottomType;
    private int price;


    public Bottom(String bottomType, int price) {
        this.bottomType = bottomType;
        this.price = price;
    }

    public String getBottomType() {
        return bottomType;
    }

    public void setBottomType(String bottomType) {
        this.bottomType = bottomType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
}
