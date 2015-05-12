<%-- 
    Document   : home.jsp
    Created on : May 6, 2015, 3:34:58 PM
    Author     : Mark
--%>
<%@page import="com.example.listener.AppEventsListener"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
    
%>
<%
    response.setHeader("Cache-Control", "no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", -1);
    
    if(session.getAttribute("username") != null)
    {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <a href="home.jsp">Home</a> |
        <a href="profile.jsp">Profile</a> |
        <a href="LogoutServlet">Logout</a>
        <% String username = (String)session.getAttribute("username"); %>
        <h1>Hello <%= username %></h1>
        <p><a href="UserController?action=add">Add User</a></p>
        
        <table style="border: 1">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.username}"/></td>
                    <td><c:out value="${user.password}"/></td>
                    <td></td>
                    <td><a href="UserController?action=edit&userID=<c:out value="${user.userID}"/>">Edit</a></td>
                    <td><a href="UserController?action=delete&userID=<c:out value="${user.userID}"/>">Delete</a></td>
                </tr>
                </c:forEach>
            </tbody>
            
        </table>
        <p>Number of login attempts: <c:out value="${counter}" /></p>
        <p>Total Active Sessions: <%= AppEventsListener.num_sessions %> </p>
    </body>
</html>
<%
    } else{
         response.sendRedirect("index.html");
    }
   
%>