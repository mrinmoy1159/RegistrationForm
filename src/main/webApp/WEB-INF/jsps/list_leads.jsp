<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@ include file="menu.jsp" %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>leads</title>
</head>
<body>
<h2>all leads</h2>
<table>
<tr>
<th>firstName</th>    <%--26.09.22 --%>
<th>lastName</th>
<th>email</th>
<th>mobile</th>
<th>delete</th>    <%--27.09.22 --%>
<th>update</th>
</tr>

<c:forEach var="lead" items="${leads}">   <%--26.09.22 --%>
<tr>
<td>${lead.firstName}</td>       <%--26.09.22 --%>
<td>${lead.lastName}</td>
<td>${lead.email}</td>         <%-- $ - act like request.getAttribute --%>
<td>${lead.mobile}</td>
<td><a href="deleteLead?id=${lead.id}">delete</a></td>     <%--27.09.22 --%>
<td><a href="updateLead?id=${lead.id}">update</a></td>    <%--29.09.22 --%>
</tr>
</c:forEach>




</table>

</body>
</html>