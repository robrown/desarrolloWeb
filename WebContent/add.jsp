<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="col-lg-6">
		<h1>Agregar Usuario</h1>
		<form action="Controller" method="get">
			Nombre Usuario:<br>
			<input class="form-control" type="text" name="txtUserName"><br>
			Contraseña:<br>
			<input class="form-control" type="password" name="txtPassword"><br>
			Nombre:<br>
			<input class="form-control" type="text" name="txtName"><br>
			Apellido Paterno:<br>
			<input class="form-control" type="text" name="txtLastOne"><br>
			Apellido Materno:<br>
			<input class="form-control" type="text" name="txtLastTwo"><br>
			DNI:<br>
			<input class="form-control" type="text" name="txtDni"><br>
			<input type="submit" class="btn btn-primary" name="accion" value="Agregar"><br>
		</form>
	</div>
		
</div>

</body>
</html>