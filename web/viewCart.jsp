<%-- 
    Document   : book-room
    Created on : Apr 29, 2020, 7:30:30 PM
    Author     : TiTi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
    </head>
    <body>
        <h1>Your Cart</h1>

        <c:set var="cart" value="${CART}"/>

        <c:if test="${empty cart}">
            <h2>You have no items in the cart. Please add some.</h2>
        </c:if>

        <c:if test="${not empty cart}">
            <c:set var="details" value="${cart.tblBookingDetailsCollection}" />
            <c:if test="${empty details}">
                <h2>You have no items in the cart. Please add some.</h2>

            </c:if>

            <c:if test="${not empty details}">

                <c:set var="total" value="${0}"/>
                <p>There are ${details.size()} items in your cart.</p>

                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Hotel</th>
                            <th>Room type</th>
                            <th>Amount</th>
                            <th>Unit price</th>
                            <th>Total</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="detail" items="${details}" varStatus="counter">
                        <form action="UpdateCartServlet" method="POST" >
                            <tr>
                                <td>${counter.count}</td>
                                <td>${detail.roomId.hotelId.name}</td>
                                <td>${detail.roomId.typeId.name}</td>
                                <td>
                                    <input type="number" min="0" name="amount" value="${detail.amount}" 
                                           style="text-align: center"/>
                                </td>
                                <td style="text-align: right">${detail.unitPrice} vnd</td>
                                <td style="text-align: right">${detail.amount * detail.unitPrice} vnd</td>
                                <td>
                                    <input type="submit" value="Update" name="btAction"/>
                                    <input type="submit" value="Delete" name="btAction" onclick=" return confirmIfDelete()"/>
                                    <input type="hidden" name="detailPosition" value="${counter.count - 1}" />
                                </td>
                            </tr>
                        </form>

                        <c:set var="total" value="${total + detail.amount * detail.unitPrice}"/>
                    </c:forEach>
                </tbody>
            </table>

            <p>Total price: ${total} vnd</p>

            <form action="ConfirmCartServlet" method="POST">
                <label>Discount Code</label>
                <input type="text" name="discountCode" value="" placeholder="Enter your discount code"/>
                <br/>
                <br/>
                <input type="submit" value="Confirm" />
            </form>
        </c:if>
    </c:if>

    <form action="ProcessServlet">
        <br/>
        <input type="submit" value="Home" name="btAction" />
    </form>

    <script>
        function confirmIfDelete() {
            return confirm('You you want to remove this item?');
        }
    </script>
</body>
</html>
