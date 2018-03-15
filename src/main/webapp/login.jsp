<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>CupCakeShop - Login</title>
    </head>
    <body>
        
         <%@include file="includes/menu.jsp" %>
         
        <form action="Control" method="post" id="login">
            <input type="text" name="username" value="" placeholder="Username" required />
            <input type="password" name="password" value="" placeholder="Password" required />
            <input type="hidden" name="origin" value="login" />
            <input type="submit" value="Log in" class="button2" />
        </form>
        
    </body>
</html>
