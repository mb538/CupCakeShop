<link href="topmenustyle.css" rel="stylesheet" type="text/css"/>

<div class="topMenu">
    <a href="index.jsp" class="button">Home</a>
    <a href="products.jsp" class="button">Manage Orders</a>
    <a href="user.jsp" class="button">User</a>
    <form action="Control" method="post" class="button">
        <input type="hidden" name="origin" value="logout" />
        <input type="submit" value="Log Out" />
    </form>
</div>
