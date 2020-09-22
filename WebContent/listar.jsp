<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="modelDAO.UserDAO" %>
<%@page import="model.User" %>
<%@page import="java.util.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Listar Usuarios</title>
</head>
<body>
<div class="container">
	<h1>Usuarios Registrados</h1>
	<a class="btn btn-success" href="Controller?accion=add"> Agregar Nuevo</a>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th class="text-center">Nombre</th>
				<th class="text-center">Apellido Paterno</th>
				<th class="text-center">Apellido Materno</th>
				<th class="text-center">Usuario</th>
				<th class="text-center">DNI</th>
				<th class="text-center">Acciones</th>
			</tr>
		</thead>
		<%
			UserDAO dao=new UserDAO();
			List<User>list=dao.listar();
			Iterator<User>iter=list.iterator();
			User usu=null;
			while(iter.hasNext()){
				usu=iter.next();
			
		%>
		<tbody>
			<tr>
				<td class="text-center"><%= usu.getName() %></td>
				<td class="text-center"><%= usu.getLast_name_one() %></td>
				<td class="text-center"><%= usu.getLast_name_two() %></td>
				<td class="text-center"><%= usu.getName() %></td>
				<td class="text-center"><%= usu.getDni() %></td>
				<td>
					<a class="btn btn-warning" href="Controller?accion=editar&dni=<%= usu.getDni() %>">Editar</a>
					<a class="btn btn-warning" href="Controller?accion=eliminar&dni=<%= usu.getDni() %>">Remove</a>
				</td>
				
			</tr>
			<% } %>
		</tbody>
	</table>
</div>
</body>
</html>