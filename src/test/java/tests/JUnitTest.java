/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import datamapper.DataMapper;
import datamapper.OrderDataMapper;
import datasource.DataSource1;
import entity.Order;
import entity.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mads
 */
public class JUnitTest {
    
    DataMapper dm = new DataMapper(new DataSource1().getDataSource());
    OrderDataMapper odm = new OrderDataMapper(new DataSource1().getDataSource());
    
    public JUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreateUser() {
        System.out.println("testCreateUser");
        User user = (new User("Henrik", "1234", false, 200, "Hello"));
        dm.createUser(user);
        User u = dm.validateUser("Henrik", "1234");
        User result = (new User(u.getUsername(), u.getPassword(), u.isAdmin(), u.getBalance(), u.getEmail()));
        
        assertEquals(user.getUsername(), u.getUsername());
        assertEquals(user.getPassword(), u.getPassword());
        assertEquals(user.isAdmin(), u.isAdmin());
        assertEquals(user.getBalance(), u.getBalance());
        assertEquals(user.getEmail(), u.getEmail());
        
        if (dm.getUser(u.getId()) != null){
            dm.deleteUser(u.getId());
        }
        assertTrue(dm.getUser(u.getId()) == null);
    }
   
    @Test
    public void testUpdateUser() {
        System.out.println("testUpdateUser");
        dm.createUser(new User("Erik", "12345", false, 200, "Hello"));
        
        User user = dm.validateUser("Erik", "12345");
        
        user.setUsername("Egon");
        user.setAdmin(true);
        user.setPassword("321");
        user.setBalance(100);
        user.setEmail("Hey");
        
        dm.updateUser(user);
        User res = dm.validateUser(user.getUsername(), user.getPassword());
        
        assertEquals("Egon", res.getUsername());
        assertEquals("321", res.getPassword());
        assertEquals(true, res.isAdmin());
        assertEquals(100, res.getBalance());
        assertEquals("Hey", res.getEmail());
        
        if(dm.getUser(res.getId()) != null){
            dm.deleteUser(res.getId());
        }
        assertTrue(dm.getUser(res.getId()) == null);
    }
    /*
    @Test
    public void testCreateOrder() {
        System.out.println("testCreateOrder");
        User user = (new User("Henrik", "1234", false, 200, "Hello"));
        dm.createUser(user);
        User res = dm.validateUser(user.getUsername(), user.getPassword());
        Order order = new Order(res.getId(), "Chocolate", "Chocolate", 3);
        odm.createOrder(order);
        
        odm.getOrder(0)
        assertTrue();
    }
*/
}
