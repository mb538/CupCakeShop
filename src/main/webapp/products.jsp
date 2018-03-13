<%@page import="entity.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="datamapper.OrderDataMapper"%>
<%@page import="datasource.DataSource1"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>CupCakeShop - Orders</title>
    </head>
    <body id="products">
        <%User user = (User) session.getAttribute("user");%> 
        <%if(user == null){ 
            response.sendRedirect("login.jsp");
          }
        %>
        <%OrderDataMapper dm = new OrderDataMapper(new DataSource1().getDataSource()); %>
        
         <%@include file="includes/topmenu.jsp" %>
         
         <h1>MANAGE ORDERS</h1>
         
        <p>
            Logged in as: <%= user.getUsername() %><br>
            Balance: <%= user.getBalance() %> kr.<br>
        </p>
        
        <h2>CREATE ORDER</h2>
        
        <form action="ProductControl" method="post" id="createOrder">
            <input type="hidden" name="userid" value ="<%= user.getId() %>" />
            <select name="bottom">
                <option value="Almond">Almond: 7kr.</option>
                <option value="Chocolate">Chocolate: 5kr.</option>
                <option value="Nutmeg">Nutmeg: 5kr..</option>
                <option value="Pistacio">Pistacio: 6kr..</option>
                <option value="Vanilla">Vanilla: 5kr..</option>
            </select>
            <select name="topping">
                <option value="Blue Cheese">Blue Cheese: 9kr.</option>
                <option value="Blueberry">Blueberry: 5kr.</option>
                <option value="Chocolate">Chocolate: 5kr.</option>
                <option value="Crispy">Crispy: 6kr.</option>
                <option value="Lemon">Lemon: 8kr.</option>
                <option value="Orange">Orange: 8kr.</option>
                <option value="Rasberry">Rasberry: 5kr.</option>
                <option value="Rum/Raisin">Rum/Raisin: 7kr.</option>
                <option value="Strawberry">Strawberry: 6kr.</option>
            </select>
            <input type="number" name="amount" placeholder="Amount" />
            <input type="hidden" name="origin" value="create" />
            <input type="submit" value="CREATE ORDER" id="button2" />
        </form>
        
        <% ArrayList<Order> orders = dm.getOrders(user.getId()); %>
        <h2>ORDERS</h2>
        </div>
        <div class="orderTable2">   
            <table class="table">
                <tr>
                    <th>Order ID</th>
                    <th>User ID</th>
                    <th>Bottom</th>
                    <th>Topping</th>
                    <th>Amount</th>
                    <th>Total Price</th>
                </tr>
                
                 <%
                for(Order o : orders)
                { %>
                    <tr>
                    <td> <%= o.getId() %> </td>  
                    <td> <%= user.getId() %> </td>  
                    <td> <%= o.getBottom() %> </td>
                    <td> <%= o.getTopping() %> </td>  
                    <td> <%= o.getAmount() %> </td>  
                    <td> <%= o.getTotalPrice() %> kr.</td>                                    
                </tr> 
                <% } %>
            </table>
                
        </div>
    </body>
</html>
