package datamapper;

import entity.User;
import java.util.ArrayList;
import dbconnector.DBConnector;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataMapper implements DataMapperInterface
{
    private DBConnector dbc = new DBConnector();

    public DataMapper(DataSource ds)
    {
        dbc.setDataSource(ds);
    }
    /*
    @Override
    public ArrayList<CupCake> getOrders() {
        ArrayList<CupCake> orders = new ArrayList();
        
        try
        {
            dbc.open();
            
            String sql = "SELECT * FROM orders";
            ResultSet resultset = dbc.query(sql);

            while(resultset.next())
            {
                int orderid = resultset.getInt("orders.orderid");
                int height = resultset.getInt("height");
                int width = resultset.getInt("width");
                int frametype = resultset.getInt("frametype");
                int price = resultset.getInt("price");
                
                CupCake o = new CupCake(orderid, bot, top, totalPrice);
                
                orders.add(o);
            }
            
            dbc.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return orders;
    }
    */
    @Override
    public ArrayList<User> getUsers()
    {
        ArrayList<User> users = new ArrayList();

        try
        {
            dbc.open();

            String sql = "SELECT * FROM user";
            PreparedStatement ps = dbc.preparedStatement(sql);
            ResultSet resultset = ps.executeQuery();
            
            while (resultset.next())
            {
                int userid = resultset.getInt("user.userid");
                String username = resultset.getString("username");
                String userpassword = resultset.getString("password");
                boolean admin = resultset.getBoolean("admin");
                int balance = resultset.getInt("balance");
                String email = resultset.getString("email");

                User u = new User(userid, username, userpassword, admin, balance, email);

                users.add(u);
            }

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public ArrayList<User> getUsers(String un)
    {
        ArrayList<User> users = new ArrayList();

        try
        {
            dbc.open();

            String sql = "SELECT * FROM user WHERE username LIKE ?";
            PreparedStatement ps = dbc.preparedStatement(sql);
            ps.setString(1, "%" + un + "%");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next())
            {
                int userid = resultSet.getInt("userid");
                String username = resultSet.getString("username");
                String userpassword = resultSet.getString("password");
                boolean admin = resultSet.getBoolean("admin");
                int balance = resultSet.getInt("balance");
                String email = resultSet.getString("email");

                User u = new User(userid, username, userpassword, admin, balance, email);

                users.add(u);
            }

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User getUser(int id)
    {
        User u = null;
        
        try
        {
            dbc.open();

            String sql = "SELECT * FROM user WHERE userid = ?";
            PreparedStatement ps = dbc.preparedStatement(sql);
            ps.setInt(1, id);
            ResultSet resultset = ps.executeQuery();
            
            while (resultset.next())
            {
                int userid = resultset.getInt("userid");
                String username = resultset.getString("username");
                String userpassword = resultset.getString("password");
                boolean admin = resultset.getBoolean("admin");
                int balance = resultset.getInt("balance");
                String email = resultset.getString("email");
                
                u = new User(userid, username, userpassword, admin, balance, email);
            }

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return u;
    }

    @Override
    public User getUser(String name)
    {
        try
        {
            dbc.open();

            String sql = "SELECT * FROM user WHERE username = ?";
            PreparedStatement ps = dbc.preparedStatement(sql);
            ps.setString(1, name);
            ResultSet resultset = ps.executeQuery();
            
            while (resultset.next())
            {
                int userid = resultset.getInt("user.userid");
                String username = resultset.getString("username");
                String userpassword = resultset.getString("password");
                boolean admin = resultset.getBoolean("admin");
                int balance = resultset.getInt("balance");
                String email = resultset.getString("email");

                return new User(userid, username, userpassword, admin, balance, email);
            }

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deleteUser(int id)
    {
        try
        {
            dbc.open();
            
            String sql = "DELETE FROM user WHERE userid = ?";
            PreparedStatement ps = dbc.preparedStatement(sql);
            ps.setInt(1, id);  
            
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

    @Override
    public boolean updateUser(User u)
    {
        
        int admin = 0;
        if (u.isAdmin() == true)
            admin = 1;
        else if (u.isAdmin() == false)
            admin = 0;
        
        try
        {
            dbc.open();
            
            String sql = "UPDATE user SET username = ?, password = ?, admin = ?, balance = ?, email = ? WHERE userid = ?";
            PreparedStatement ps = dbc.preparedStatement(sql);
            
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setInt(3, admin);
            ps.setInt(4, u.getBalance());
            ps.setString(5, u.getEmail());
            ps.setInt(6, u.getId());
            
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

    public boolean createUser(User u)
    {
        int admin = 0;
        if (u.isAdmin() == true)
            admin = 1;
        else if (u.isAdmin() == false)
            admin = 0;
        try
        {
            dbc.open();
            
            String sql = "INSERT INTO user VALUES(null, ?, ?, ?, ?, ?)";
            PreparedStatement ps = dbc.preparedStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setInt(3, admin);
            ps.setInt(4, u.getBalance());
            ps.setString(5, u.getEmail());
            
            ps.executeUpdate();
//            String sql = "insert into user values(null, "
//                    + "'" + u.getUsername() + "', "
//                    + "'" + u.getPassword() + "', "
//                    + "'" + admin + "', "
//                    + "'" + u.getBalance() + "', '"
//                    + u.getEmail() + "')";
//
//            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }
    
    public User validateUser(String username, String password)
    {
        User user = null;
        
        try
        {
            dbc.open();
            
            /*
            String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";
            System.out.println("SQL: " + sql);
            ResultSet resultSet = dbc.executeQuery(sql);
            */
            
            //PreparedStatement
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = dbc.preparedStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            
            if (resultSet.next())
            {
                int id = resultSet.getInt("userid");
                boolean admin = resultSet.getInt("admin") > 0;
                
                user = new User(id, username, password, admin);
            }

            dbc.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return user;
    }
}