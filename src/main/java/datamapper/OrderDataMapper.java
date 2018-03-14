package datamapper;

import dbconnector.DBConnector;
import entity.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

public class OrderDataMapper {
    
    private DBConnector dbc = new DBConnector();

    public OrderDataMapper(DataSource ds)
    {
        dbc.setDataSource(ds);
    }
    
    //Creates an order
    public void createOrder(Order o){
        try
        {
            dbc.open();
            
            String sql = "INSERT INTO orders VALUES(null, ?, ?, ?, ?)";
            PreparedStatement ps = dbc.preparedStatement(sql);
            
            ps.setInt(1, o.getUserid());
            ps.setString(2, o.getBottom());
            ps.setString(3, o.getTopping());
            ps.setInt(4, o.getAmount());
            
            ps.executeUpdate();

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    //Updates an order
    public boolean updateOrder(Order o){
        try
        {
            dbc.open();
            
            String sql = "UPDATE order SET orderid = ?, userid = ?, bottom = ?, topping = ?, amount = ? WHERE userid = ?";
            
            PreparedStatement ps = dbc.preparedStatement(sql);
            ps.setInt(1, o.getId());
            ps.setInt(2, o.getUserid());
            ps.setString(3, o.getBottom());
            ps.setString(4, o.getTopping());
            ps.setInt(4, o.getAmount());
            ps.setInt(5, o.getUserid());
            
            ps.executeUpdate();

            dbc.close();

            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }
    
    //Deletes an order
    public boolean deleteOrder(int orderid){
        try
        {
            dbc.open();
    
            String sql = "DELETE FROM orders WHERE orderid = ?";
            PreparedStatement ps = dbc.preparedStatement(sql);
            ps.setInt(1, orderid);  
            ps.executeUpdate();

            dbc.close();

            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }
    //Returns a single order
    public Order getOrder(int id){
        try
        {
            dbc.open();

            String sql = "SELECT *, toppings.price, bottoms.price, (toppings.price+bottoms.price)*orders.amount AS totalprice FROM orders WHERE orderid = ?";
            PreparedStatement ps = dbc.preparedStatement(sql);
            ps.setInt(1, id);
            ResultSet resultset = ps.executeQuery();
            
            while (resultset.next())
            {
                int orderid = resultset.getInt("orderid");
                int userid = resultset.getInt("userid");
                String bottom  = resultset.getString("bottom");
                String topping = resultset.getString("topping");
                int totalPrice = resultset.getInt("totalprice");
                int amount = resultset.getInt("amount");

                return new Order(orderid, userid, bottom, topping, totalPrice, amount);
            }

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }
    //Returns an ArrayList of all orders
    public ArrayList<Order> getAllOrders(){
        ArrayList<Order> orders = new ArrayList();

        try
        {
            dbc.open();

            String sql = "SELECT *, toppings.price, bottoms.price, (toppings.price+bottoms.price)*orders.amount AS totalprice FROM"
                    + "((orders LEFT JOIN toppings ON orders.topping=toppings.topping) "
                    + "LEFT JOIN bottoms ON orders.bottom=bottoms.bottom)"; 
            PreparedStatement ps = dbc.preparedStatement(sql);
            ResultSet resultset = ps.executeQuery();
            
            while (resultset.next())
            {
                int orderid = resultset.getInt("orderid");
                int userid = resultset.getInt("userid");
                String bottom = resultset.getString("bottom");
                String topping = resultset.getString("topping");
                int totalPrice = resultset.getInt("totalprice");
                int amount = resultset.getInt("amount");

                Order o = new Order(orderid, userid, bottom, topping, totalPrice, amount);

                orders.add(o);
            }
            
            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return orders;
        
    } 
    //Returns an ArrayList of all orders from a customer
    public ArrayList<Order> getOrders(int userId){
        ArrayList<Order> orders = new ArrayList();

        try
        {
            dbc.open();

            String sql = "SELECT *, toppings.price, bottoms.price, (toppings.price+bottoms.price)*orders.amount AS totalprice FROM"
                    + "((orders LEFT JOIN toppings ON orders.topping=toppings.topping) "
                    + "LEFT JOIN bottoms ON orders.bottom=bottoms.bottom) WHERE userid = ?"; 
            PreparedStatement ps = dbc.preparedStatement(sql);
            ps.setInt(1, userId);
            ResultSet resultset = ps.executeQuery();
            
            while (resultset.next())
            {
                int orderid = resultset.getInt("orderid");
                int userid = resultset.getInt("userid");
                String bottom = resultset.getString("bottom");
                String topping = resultset.getString("topping");
                int totalPrice = resultset.getInt("totalprice");
                int amount = resultset.getInt("amount");

                Order o = new Order(orderid, userid, bottom, topping, totalPrice, amount);

                orders.add(o);
            }
            
            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return orders;
    }
}
