<%-- 
    Document   : profile
    Created on : May 6, 2015, 4:04:29 PM
    Author     : Mark
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body>
        <h1>Hello <%= session.getAttribute("username") %></h1>
    </body>
</html>
