<%-- 
    Document   : logout
    Created on : 7 Mar, 2020, 12:01:20 PM
    Author     : Arpit Mishra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    session.removeAttribute("admin");
    response.sendRedirect("../login.jsp");
%>