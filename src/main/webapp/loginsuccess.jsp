<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ page import="com.example.LoginTest.LoginDAO" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Login Landing Page</title>
</head>

<body>


<jsp:useBean id="login" class="bean.LoginBean" />

<jsp:setProperty property="*" name="login" />

<%
    LoginDAO loginDao = new LoginDAO();
    boolean status = loginDao.LoginDAOConnection(login);
    if (status) {
        out.print("Welcome " + request.getParameter("username") + ", you are now logged in<br>");
    }
    else
    {
        out.print("<h2>You are not logged in...</h2>");
    }
%>

<a href="logout">Logout</a>

</body>

</html>