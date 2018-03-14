<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>CupCakeShop</title>
    </head>
    <body>
        
        <%@include file="includes/menu.jsp" %>
        
        <h1>CupCakeShop</h1>
        
        <h2>SEARCH USER</h2>
        
        <form id="formSearch" action="Control" method="post">
            <label class="formLabel" for="username">Username</label>
            <input type="text" name="username" />
            <input type="hidden" name="origin" value="search" />
            <input class="button" id="button2" type="submit" value="SEARCH USER" />
        </form>
        
        <h2>CREATE USER</h2>
        
        <form id="formCreate" action="Control" method="post">
            <label class="formLabel" for="username">Username</label>
            <input type="text" name="username" required/>
            <label class="formLabel" for="password">Password</label>
            <input type="text" name="password" required />
            <label class="formLabel" for="admin">Admin</label>
            <input type="text" name="admin" required />
            <label class="formLabel" for="balance">Balance</label>
            <input type="number" name="balance" required/>
            <label class="formLabel" for="email">Email</label>
            <input type="text" name="email" required/>
            <input type="hidden" name="origin" value="create" />
            <input class="button" id="button2" type="submit" value="CREATE USER" />
        </form>
        
    </body>
</html>
