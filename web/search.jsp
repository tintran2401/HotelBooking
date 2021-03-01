<%-- 
    Document   : search
    Created on : Apr 29, 2020, 12:27:13 AM
    Author     : TiTi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Hotel</title>
    </head>
    <body>
        <c:if test="${not empty USER}">
            <h3 style="color: orangered">Welcome, ${USER.fullName}</h3><br/>
            <a href="login.jsp">Logout</a>
        </c:if>
        <h1>Search Hotel</h1>

        <form action="ProcessServlet" method="POST" onsubmit="return validateForm();">
            <label>Hotel name: </label>
            <input type="text" name="hotelName" value="${param.hotelName}" placeholder="Hotel name..."/>
            <br/>

            <label>Hotel location: </label>
            <input type="text" name="hotelLocation" value="${param.hotelLocation}" placeholder="Hotel location..."/>
            <br/>

            <jsp:useBean id="now" class="java.util.Date"/>
            <fmt:formatDate var="currentDate" value="${now}" pattern="yyyy-MM-dd"/>
            <label>Checkin date: </label>
            <input type="date" name="checkinDate" value="${not empty param.checkinDate ? param.checkinDate : currentDate}"/>
            <br/>

            <label>Checkout date: </label>
            <input type="date" name="checkoutDate" value="${not empty param.checkoutDate ? param.checkoutDate : currentDate}" />
            <br/>

            <label>Amount: </label>
            <input type="number" min="0" name="amount" value="${not empty param.amount ? param.amount : 1}" />
            <br/>

            <input type="submit" value="Search hotel" name="btAction" />
            <br/>
        </form>

        <form action="ViewCartServlet" method="POST">
            <br/>
            <input type="submit" value="View cart" name="btAction" />
            <br/>
        </form>


        <c:if test="${not empty requestScope.HOTELS}">
            <c:set var="hotels" value="${requestScope.HOTELS}"/>
            <br/>
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Name</th>
                        <th>Location</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="hotel" items="${hotels}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${hotel.name}</td>
                            <td>${hotel.location}</td>
                            <td>
                                <input type="button" value="View details" onclick="showHotelDetail('hotel-detail-${hotel.id}')"/>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <c:forEach var="hotel" items="${hotels}">
                <div id="hotel-detail-${hotel.id}" class="hotel-detail" style="display: none;"> 
                    <p>Hotel ${hotel.name}</p>
                    <c:forEach var="room" items="${hotel.tblRoomCollection}" varStatus="counter">
                        <form action="AddToCartServlet" method="POST" onsubmit="applySearchValues(event)">
                            <p>Room #${room.id}, available ${room.amount} rooms, 
                                room type: ${room.typeId.name}, unit price ${room.typeId.price} vnd
                                <input type="submit" value="Add to cart" name="btAction"/>
                            </p>

                            <input type="hidden" value="${room.id}" name="roomId"/>
                            <input type="hidden" value="${param.hotelName}" name="hotelName"/>
                            <input type="hidden" value="${param.hotelLocation}" name="hotelLocation"/>
                            <input type="hidden" value="${param.checkinDate}" name="checkinDate"/>
                            <input type="hidden" value="${param.checkoutDate}" name="checkoutDate"/>
                            <input type="hidden" value="${param.amount}" name="amount"/>

                        </form>
                    </c:forEach>
                </div>
            </c:forEach>

        </c:if>
        <c:if test="${empty requestScope.HOTELS}">
            <h2>Sorry, there are no hotel available at the moment. Please come back later.</h2>
        </c:if>

        <script>
            function showHotelDetail(id) {
                let details = document.getElementsByClassName('hotel-detail');
                for (detail of details) {
                    detail.style.display = 'none';
                }
                document.getElementById(id).style.display = 'block';
            }
            function validateForm() {
                let checkinDate = document.getElementsByName('checkinDate')[0].value;
                let checkoutDate = document.getElementsByName('checkoutDate')[0].value;
                if (checkinDate > checkoutDate) {
                    alert('ERROR: Checkin date must not be greater than checkout date!');
                    return false;
                }
                return true;
            }
            function applySearchValues(event) {
                let name = document.getElementsByName('hotelName')[0].value;
                let location = document.getElementsByName('hotelLocation')[0].value;
                let checkinDate = document.getElementsByName('checkinDate')[0].value;
                let checkoutDate = document.getElementsByName('checkoutDate')[0].value;
                let amount = document.getElementsByName('amount')[0].value;
                
                let form = event.target;

                form.elements.hotelName.value = name;
                form.elements.hotelLocation.value = location;
                form.elements.checkinDate.value = checkinDate;
                form.elements.checkoutDate.value = checkoutDate;
                form.elements.amount.value = amount;
            }
        </script>
    </body>
</html>
