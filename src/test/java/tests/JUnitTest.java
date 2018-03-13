/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import datamapper.DataMapper;
import datamapper.OrderDataMapper;
import datasource.DataSource1;
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
        
        assertEquals(user, result);
        
        if (dm.getUser(u.getId()) != null){
            dm.deleteUser(u.getId());
        }
    }
    /*
    @Test
    public void testUpdateUser() {
        System.out.println("testUpdateUser");
        
        assertTrue();
    }
    @Test
    public void testDeleteUser() {
        System.out.println("testDeleteUser");
        
        assertTrue();
    }
    @Test
    public void testCreateOrder() {
        System.out.println("testCreateOrder");
        
        assertTrue();
    }
    @Test
    public void testUpdateOrder() {
        System.out.println("testUpdateOrder");
        
        assertTrue();
    }
    @Test
    public void testDeleteOrder() {
        System.out.println("testDelteOrder");
        
        assertTrue();
    }
*/
}
