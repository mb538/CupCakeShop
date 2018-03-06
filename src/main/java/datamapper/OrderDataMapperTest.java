/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamapper;

import datasource.DataSource1;
import entity.Order;
import java.util.ArrayList;

/**
 *
 * @author Mads
 */
public class OrderDataMapperTest {
    public static void main(String[] args){
        OrderDataMapper dm = new OrderDataMapper(new DataSource1().getDataSource());
        
//        ArrayList<Order> orders = dm.getAllOrders();
//        System.out.println("Amount: " + orders.get(4).getAmount());
//        System.out.println("Total Price: " + orders.get(4).getTotalPrice());
//        Order o = new Order(5, "Almond", "Strawberry", 7);
//        dm.createOrder(o);
        dm.deleteOrder(10);
//        dm.getOrders(1);
        
    }
}
