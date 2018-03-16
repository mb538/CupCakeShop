<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>CupCakeShop - User</title>
    </head>
    <body>
        
        <%@include file="includes/topmenu.jsp" %>
        
        <h1>USER</h1>
            
        <%
            User user = (User) session.getAttribute("user");
            
            if (user == null)
            {           
                user = new User(0, "Anonymous", "none", false);
                response.sendRedirect("login.jsp");           
            }
        %>       
        
        <h2>UPDATE USER</h2>
        
        <form action="Control" method="post" id="formUpdate">
            <label class="formLabel" for="username">Username</label>
            <input type="text" name="username" value="<%= user.getUsername() %>" pattern=".{3,20}" title="Please enter a username between 3 and 20 characters" required />
            <label class="formLabel" for="password">Password</label>
            <input type="text" name="password" value="<%= user.getPassword() %>" pattern=".{3,20}" title="Please enter a password between 3 and 20 characters" required/>
            <input type="hidden" name="admin" value="<%= user.isAdmin() %>" required />
            <input type="hidden" name="balance" value="<%= user.getBalance() %>" required />
            <label class="formLabel" for="email">Email</label>
            <input type="email" name="email" value="<%= user.getEmail() %>" pattern=".{3,20}" required />
            <input type="hidden" name="origin" value="update" />
            <input type="submit" value="UPDATE USER" class="button2" />
        </form>
        
        <h2>DELETE USER</h2>
        
        <form action="Control" method="post" id="formDelete">
            <input type="hidden" name="origin" value="delete" />
            <input type="submit" value="DELETE USER" class="button2" onclick="return confirm('Are you sure?')" />
        </form>

    </body>
</html>
