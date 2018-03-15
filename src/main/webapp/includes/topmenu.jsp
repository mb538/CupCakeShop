<style>
    *{
        box-sizing: border-box;
    }
    body {
        margin: 0;     
    }
    .topMenu{
        overflow: hidden;
        background-color: #3b2613;      
    }
    .topMenu a{
        float: left;
        display: block;
        color: #a48c6f; 
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }
    .topMenu input{
        float: left;
        display: block;
        color: #a48c6f;    
        padding: 6px 16px;
        text-decoration: none;
        background-color: #3b2613;
        border: none;
    }
    .topMenu input:hover{
        background-color: #7a5f43;
        color: orange;
    }
    .topMenu a:hover{
        background-color: #7a5f43;
        color: orange;
    }
</style>

<div class="topMenu">
    <a href="index.jsp" class="button">Home</a>
    <a href="products.jsp" class="button">Manage Orders</a>
    <a href="user.jsp" class="button">User</a>
    <form action="Control" method="post" id="logout">
        <input type="hidden" name="origin" value="logout" />
        <input type="submit" value="Log Out" class="button" />
    </form>
</div>
