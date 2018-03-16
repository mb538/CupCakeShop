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
            <input type="text" name="username" max="50" />
            <input type="hidden" name="origin" value="search" />
            <input class="button2" type="submit" value="SEARCH USER" />
        </form>
        
        <h2>CREATE USER</h2>
        
        <form id="formCreate" action="Control" method="post">
            <label class="formLabel" for="username">Username</label>
            <input type="text" name="username" pattern=".{3,20}" title="Please enter a username between 3 and 20 characters" required/>
            <label class="formLabel" for="password">Password</label>
            <input type="text" name="password" pattern=".{3,20}" title="Please enter a password between 3 and 20 characters" required />
            <label class="formLabel" for="admin">Admin</label>
            <select name="admin">
                <option value="true">Yes</option>
                <option value="false">No</option>
            </select>
            <label class="formLabel" for="balance">Balance</label>
            <input type="number" name="balance" min="0" max="10000" step="1" required/>
            <label class="formLabel" for="email">Email</label>
            <input type="email" name="email" pattern=".{3,20}" required/>
            <input type="hidden" name="origin" value="create" />
            <input class="button2" type="submit" value="CREATE USER" />
        </form>
        
    </body>
</html>
