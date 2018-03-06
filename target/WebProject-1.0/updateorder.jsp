<%@page import="entity.Order"%>
<%@page import="datamapper.OrderDataMapper"%>
<%@page import="datasource.DataSource1"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Order</title>
    </head>
    <body>
        <%OrderDataMapper dm = new OrderDataMapper(new DataSource1().getDataSource()); %>
        <% int orderid = Integer.parseInt(request.getParameter("orderid")); %>
        <%Order order = dm.getOrder(orderid);%>
        
        <h2> UPDATE ORDER: <%= orderid %> </h2>           
      
        <form action="ProductControl" method="post">
            <input type="hidden" name="orderid" value ="<%= order.getId() %>" />
            <input type="hidden" name="userid" value ="<%= order.getUserid() %>" />
            <select name="bottom">
                <option value="Almond">Almond: 7kr.</option>
                <option value="Chocolate">Chocolate: 5kr.</option>
                <option value="Nutmeg">Nutmeg: 5kr.</option>
                <option value="Pistacio">Pistacio: 6kr.</option>
                <option value="Vanilla">Vanilla: 5kr.</option>
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
            <input type="hidden" name="origin" value="update" />
            <input type="submit" value="UPDATE ORDER" />
        </form>
            
        <h2>DELETE ORDER</h2>
        
        <form action="ProductControl" method="post">
            <input type="hidden" value="<%= order.getId() %>" />
            <input type="hidden" name="origin" value="delete" />
            <input type="submit" value="DELETE ORDER" />
        </form>
        
        <a href="index.jsp">BACK...</a>
    </body>
</html>
