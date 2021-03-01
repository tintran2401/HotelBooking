<%-- 
    Document   : addSuccess
    Created on : Apr 29, 2020, 8:28:11 PM
    Author     : TiTi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add to cart</title>
    </head>
    <body>
        <h2 style="color: limegreen">Add to cart success!</h2>

        <form action="SearchServlet" method="POST">
            <input type="submit" value="Back to search" name="btAction" />
            
            <input type="hidden" value="${param.hotelName}" name="hotelName" id="cart-hotelName"/>
            <input type="hidden" value="${param.hotelLocation}" name="hotelLocation" id="cart-hotelLocation"/>
            <input type="hidden" value="${param.checkinDate}" name="checkinDate" id="cart-checkinDate"/>
            <input type="hidden" value="${param.checkoutDate}" name="checkoutDate" id="cart-checkoutDate"/>
            <input type="hidden" value="${param.amount}" name="amount" id="cart-amount"/>
        </form>
        
        <form action="ViewCartServlet" method="POST">
            <br/>
            <input type="submit" value="View cart" name="btAction" />
            <br/>
        </form>
    </body>
</html>
