<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/Style_Ingreso.css">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<title>Ingreso</title>
</head>
<body>
	<header>
	     <img src="img/Por.jpg">
	     <p>Control de Calidad</p>
    </header>
    <div id="subtitulo">
           Registro de control de cursos libres y matriculas
        </div>
        <div id="contenido">
            <div id="login">
                 <form method="post" action="p_verifica.jsp">
                     <table id="login">
                          <tr>
                              <td>usuario:</td>
                              <td><input name="xlogin" size="15"/></td>
                           </tr>
                           <tr>
                              <td>clave:</td>
                              <td><input type="password" name="xclave" size="15"/></td>
                           </tr> 
                           <tr>
                              <td colspan="2" align="right"><input type="submit" value="Aceptar"/></td>
                           </tr>
                        </table>
                    </form>
                </div>
                <div id="derecha">
                    <img src="img/bienvenida.jpg" width="780" height="580"/>
                </div>
        </div>
</body>
</html>