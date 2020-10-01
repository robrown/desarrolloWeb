<%@include file="/header.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <div id="contenido">
    <h3>Listado de Usuarios</h3>
    <form method=POST action=m_usuarios_controller.jsp>
       <input type=HIDDEN name=accion value="NUEVO_ELIMINAR_REGISTRO">
       <table id="listado">
          <tr id="listadoHeader">
              <th>Sel.</th>
              <th>Codigo</th>
              <th>Nombre</th>
              <th>Login</th>
              <th>Tipo</th>
              <th>Estado</th>
          </tr>
        <c:forEach items="${arrData}" var="registro">
          <tr id="listadoDatos">
              <td><input type=checkbox name='xcod' value=<c:out value='${registro[0]}'/> > </td>
              <td><c:out value='${registro[0]}'/></td>
              <td><a href=m_usuarios_controller.jsp?accion=MODIFICAR_REGISTRO&xcod=<c:out value='${registro[0]}'/> >
                  <c:out value='${registro[1]}' /></a></td>
              <td><c:out value='${registro[2]}'/></td>
              <td><c:out value='${registro[3]}'/></td>
              <td><c:out value='${registro[4]}'/></td>
          </tr>
        </c:forEach>
       </table>
       <br>
       <input type=submit name=boton value="Eliminar Registros">
       <input type=submit name=boton value="Nuevo Registro">
    </form>
  </div>
