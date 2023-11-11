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
<body style="background-color:lightgreen; color:blue">
<h2><u>Create Lead</u></h2>
<form action="saveLead" method="post">
<pre>
First Name <input type="text" name="firstName"/>
Last Name <input type="text" name="lastName"/>
Email         <input type="text" name="email"/>
Mobile       <input type="text" name="mobile"/>
                               <%--name should be same as entity(Lead.java)class --%>
 <input type="submit" value="save"/>
</pre>
<%-- 
Source: <select name="">
                  <option value="">Online</option>
                  <option value="">News Paper</option>
                  <option value="">Webiner</option>
                  <option value="">Tv ads</option>
</select>
--%>
            
</form>
       ${msg}

</body>
</html>