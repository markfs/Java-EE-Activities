<%-- 
    Document   : home.jsp
    Created on : May 6, 2015, 3:34:58 PM
    Author     : Mark
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.example.model.UserBean"%>
<%
    response.setHeader("Cache-Control", "no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", -1);
    
    
    if(session.getAttribute("username") != null)
    {
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <a href="home.jsp">Home</a> |
        <a href="profile.jsp">Profile</a> |
        <a href="LogoutServlet">Logout</a><br/>
        
        <% String username = (String)session.getAttribute("username"); %>
        <h1>Hello <%= username %></h1>
        <%
            UserBean user1 = new UserBean();
            user1 = (UserBean)session.getAttribute("user");
            if(user1 == null){
        %>
        <form method="POST" action="UserController">
            <pre>
                Username: <input type="text" name="username"/>
                Password: <input type="password" name="password"/>
                <input type="submit">
            </pre>
        </form>
        <% } else { %>
        <form method="POST" action="UserController">
            <pre>
                Username: <input type="text" name="username" value="<c:out value="${user.username}"/>"/>
                Password: <input type="password" name="password" value="<c:out value="${user.password}"/>"/>
                <input type="submit">
            </pre>
        </form>
        <% }%>
    </body>
</html>
<%
    } else{
         response.sendRedirect("index.html");
    }
   
%>
