<%-- 
    Document   : confirmCart
    Created on : Apr 29, 2020, 10:25:55 PM
    Author     : TiTi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Cart Page</title>
    </head>
    <body>
        <h1>Confirm cart result</h1>
        <c:if test="${RESULT}">
            <h2 style="color: limegreen">Success!</h2>
        </c:if>
        <c:if test="${not RESULT}">
            <h2 style="color: salmon">Fail!</h2>
        </c:if>
        <c:if test="${WARNING}">
            <h3 style="color: gold">Warning: The room amount in your booking exceeded the available amount!</h3>
        </c:if>
            <form action="ProcessServlet" >
                <br/>
                <input type="submit" value="Home" name="btAction"/>
            </form>
    </body>
</html>
