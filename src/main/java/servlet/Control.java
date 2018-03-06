package servlet;

import datamapper.DataMapper;
import datasource.DataSource1;
import entity.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Control", urlPatterns = { "/Control" })
public class Control extends HttpServlet
{
    DataMapper dm;

    public Control()
    {
        dm = new DataMapper(new DataSource1().getDataSource());
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        
        switch(request.getParameter("origin"))
        {
            case "login":
                {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");

                    User user = dm.validateUser(username, password);

                    request.getSession().setAttribute("user", user);

                    //request.getRequestDispatcher("user.jsp").forward(request, response);
                    response.sendRedirect("user.jsp");                

                }
                break;
            case "search":
                {
                    String username = request.getParameter("username");

                    ArrayList<User> users = dm.getUsers(username);

                    request.getSession().setAttribute("users", users);

                    response.sendRedirect("users.jsp");

                }
                break;
            case "create":
                {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
                    int balance = Integer.parseInt(request.getParameter("balance"));
                    String email = request.getParameter("email");

                    dm.createUser(new User(username, password, admin, balance, email));

                    response.sendRedirect("usercreated.jsp");

                }
                break;
            case "update":
                {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
                    int balance = Integer.parseInt(request.getParameter("balance"));
                    String email = request.getParameter("email");
                    
                    User user = (User) request.getSession().getAttribute("user");

                    if (user != null)
                    {
                        user.setUsername(username);
                        user.setPassword(password);
                        user.setAdmin(admin);
                        user.setBalance(balance);
                        user.setEmail(email);

                        dm.updateUser(user);

                        response.sendRedirect("userupdated.jsp");
                    }                

                }
                break;
            case "delete":
                {
                    User user = (User) request.getSession().getAttribute("user");

                    if (user != null)
                    {
                        dm.deleteUser(user.getId());

                        response.sendRedirect("userdeleted.jsp");
                    }                

                }
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}