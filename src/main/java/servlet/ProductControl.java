package servlet;

import datamapper.OrderDataMapper;
import datasource.DataSource1;
import entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mads
 */
@WebServlet(name = "ProductControl", urlPatterns = {"/ProductControl"})
public class ProductControl extends HttpServlet {

    OrderDataMapper dm;

    public ProductControl()
    {
        dm = new OrderDataMapper(new DataSource1().getDataSource());
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        switch(request.getParameter("origin"))
        {
            case "create":
                {
//                    int orderid = Integer.parseInt(request.getParameter("orderid"));
                    int userid = Integer.parseInt(request.getParameter("userid"));
                    String bottom = request.getParameter("bottom");
                    String topping = request.getParameter("topping");    
                    int amount = Integer.parseInt(request.getParameter("amount"));      

                    dm.createOrder(new Order(userid, bottom, topping, amount));

                    response.sendRedirect("products.jsp");        

                }
                break;
                
            case "update":
                {
                    int orderid = Integer.parseInt(request.getParameter("orderid"));
                    int userid = Integer.parseInt(request.getParameter("userid"));
                    String bottom = request.getParameter("bottom");
                    String topping = request.getParameter("topping");
                    
//                    Order order = (Order) request.getSession().getAttribute("order"); //.getAttribute("order")????????
                    
                    if (dm.getOrder(orderid) != null)
                    {
                        Order order = dm.getOrder(orderid);
                        order.setId(orderid);
                        order.setUserid(userid);
                        order.setBottom(bottom);
                        order.setTopping(topping);

                        dm.updateOrder(order);

                        response.sendRedirect("orderupdated.jsp");
                    }                

                }
            case "delete":
                {
                    int orderid = Integer.parseInt(request.getParameter("orderid"));
                    
//                    Order order = (Order) request.getSession().getAttribute("order"); //////////////////////////////
                    
                    if (dm.getOrder(orderid) != null)
                    {
                        dm.deleteOrder(orderid); // order.getId()

                        response.sendRedirect("orderdeleted.jsp"); 
                    }                

                }
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
