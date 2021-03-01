<%-- 
    Document   : login
    Created on : Apr 29, 2020, 11:06:17 PM
    Author     : TiTi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="LoginServlet" method="POST">
            <label>Email</label>
            <input type="email" name="email" required=""/>
            <br/>
            <label>Password</label>
            <input type="password" name="password" value="" required=""/>
            <br/>
            <input type="submit" value="Login" /><br/>
            <a href="register.jsp">Register<a/>
        </form>
    </body>
</html>
