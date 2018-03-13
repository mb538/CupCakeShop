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
            
            if (user != null)
            {
                out.print("Login worked");
            }
            else
            {           
                user = new User(0, "Anonymous", "none", false);
            }
        %>

        <p>
            Logged in as: <%= user.getUsername() %><br>
            Id: <%= user.getId() %><br>
            Admin: <%= user.isAdmin() %><br>
            Balance: <%= user.getBalance() %> kr.<br>
            Email: <%= user.getEmail() %><br>
        </p>
        
        
        <h2>UPDATE USER</h2>
        
        <form action="Control" method="post" id="formUpdate">
            <input type="text" name="username" value="<%= user.getUsername() %>" required />
            <input type="text" name="password" value="<%= user.getPassword() %>" required/>
            <input type="hidden" name="admin" value="<%= user.isAdmin() %>" required />
            <input type="hidden" name="balance" value="<%= user.getBalance() %>" required />
            <input type="text" name="email" value="<%= user.getEmail() %>" required />
            <input type="hidden" name="origin" value="update" />
            <input type="submit" value="UPDATE USER" id="button2" />
        </form>
        
        <h2>DELETE USER</h2>
        
        <form action="Control" method="post" id="formDelete">
            <input type="hidden" name="origin" value="delete" />
            <input type="submit" value="DELETE USER" id="button2" />
        </form>

    </body>
</html>
