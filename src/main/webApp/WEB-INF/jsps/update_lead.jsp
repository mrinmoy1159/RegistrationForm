<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Lead</title>
</head>
          <%--any thing under WEB-INF can call through only controller layer --%>
<body>
<h2><u>UPDATE Lead</u></h2>   <%--29.09.22 --%>
<form action="updateOneLead" method="post">
<pre>
<input type="hidden" name="id" value="${lead.id}"/>
First Name <input type="text" name="firstName" value="${lead.firstName}"/>
Last Name <input type="text" name="lastName" value="${lead.lastName}"/>
Email         <input type="text" name="email" value="${lead.email}"/>
Mobile       <input type="text" name="mobile" value="${lead.mobile}"/>
                               <%--name should be same as entity(Lead.java)class --%>
 <input type="submit" value="update"/>
</pre>
           
</form>
       ${msg}

</body>
</html>