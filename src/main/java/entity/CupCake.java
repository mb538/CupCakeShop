package entity;

public class CupCake {
    
    private Bottom bot;
    private Topping top;
    private int totalPrice;

    public CupCake(Bottom bot, Topping top, int totalPrice) {
        this.bot = bot;
        this.top = top;
        this.totalPrice = totalPrice;
    }

    public Bottom getBot() {
        return bot;
    }

    public void setBot(Bottom bot) {
        this.bot = bot;
    }

    public Topping getTop() {
        return top;
    }

    public void setTop(Topping top) {
        this.top = top;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
}
