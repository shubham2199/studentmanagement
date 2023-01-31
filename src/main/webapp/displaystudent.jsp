<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
</head>
<body>
<% ResultSet s = (ResultSet) session.getAttribute("view"); %>

<table cellpadding="20px" border="1">
<th>id</th>
<th>name</th>
<th>stream</th>
<th>fees</th>

<% while(s.next()){%>
<tr>
<td><%= s.getInt(1) %></td>
<td><%= s.getString(2) %></td>
<td><%= s.getString(3) %></td>
<td><%= s.getLong(4) %></td>
</tr>
<%} %>
</table>
</body>
</html>