<%-- 
    Document   : register
    Created on : Apr 29, 2020, 11:08:17 PM
    Author     : TiTi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register</h1>
        <form action="RegisterServlet" method="POST">
            <label>Email</label>
            <input type="email" name="email" required=""/>
            <br/>
            <label>Full Name</label>
            <input type="text" name="fullname" required=""/>
            <br/>
            <label>Password</label>
            <input type="password" name="password" value="" required=""/>
            <br/>
            <label>Confirm password</label>
            <input type="password" name="confirm" value="" required=""/>
            <br/>
            <label>Phone</label>
            <input type="number" name="phone" value="" required=""/>
            <br/>
            <label>Address</label>
            <input type="text" name="address" value="" required=""/>
            <br/>
            <input type="submit" value="Register" />
            <br/>
        </form>
    </body>
</html>
