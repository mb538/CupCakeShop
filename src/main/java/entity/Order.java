package entity;

public class Order {

    private int id;
    //private int date;
    private Bottom bot;
    private Topping top;
    private int totalPrice;
    private int amount;
//    private int bottomid;
//    private int toppingid;
    private int userid;
    private String bottom;
    private String topping;

     public Order(String bottom, String topping, int amount) {
        this.bottom = bottom;
        this.topping = topping;
        this.amount = amount;
    }
     
    public Order(int userid, String bottom, String topping, int amount) {
        this.userid = userid;
        this.bottom = bottom;
        this.topping = topping;
        this.amount = amount;
    }

    public Order(int id, int userid, String bottom, String topping, int amount) {
        this.id = id;
        this.userid = userid;
        this.bottom = bottom;
        this.topping = topping;
        this.amount = amount;
    }

    public Order(int id, int userid, String bottom, String topping, int totalPrice, int amount) {
        this.id = id;
        this.userid = userid;
        this.bottom = bottom;
        this.topping = topping;
        this.totalPrice = totalPrice;
        this.amount = amount;
    }
    
    
/*
    public Order(int id, int date, Bottom bot, Topping top, int totalPrice) {
        this.id = id;
        this.date = date;
        this.bot = bot;
        this.top = top;
        this.totalPrice = totalPrice;
    }
*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
/*
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
*/
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
