<%@page import="modelo.LoginDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Bienvenido</title>
	</head>
		<body>
	<h1>Bienvenido, <%= request.getAttribute("nombre") %> <%= request.getAttribute("apellido") %></h1>
    <p>Su RUT es: <%= request.getAttribute("rut") %></p> 
		</body>
</html>

