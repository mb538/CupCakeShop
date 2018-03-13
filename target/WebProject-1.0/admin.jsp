<%@page import="datamapper.OrderDataMapper"%>
<%@page import="datasource.DataSource1"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>
        <%User user = (User) session.getAttribute("user"); %>
        <%OrderDataMapper dm = new OrderDataMapper(new DataSource1().getDataSource()); %>
        
        <%@include file="includes/topmenu.jsp" %>
        
        <h1>Admin</h1>
        
        <h2>Orders</h2>
        
        <h2>Update Orders</h2>
        
    </body>
</html>
