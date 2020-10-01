<%@include file="/header.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="contenido">

  <h3><c:out value='${titulo}'/></h3>
  <form name=mod_opcion method=POST action=m_usuarios_controller.jsp>
     <input type=hidden name=accion value='GRABAR_REGISTRO'>
     <input type=hidden name=operacion value='<c:out value='${operacion}'/>'>
     <input type=hidden name=xcod value="<c:out value='${registro[0]}'/>">
     <table id="editar">
        <tr><th>Codigo: </th>
            <td><c:out value='${registro[0]}'/> </td> </tr>
        <tr><th>Nombre: </th>
            <td><input name=xnom value="<c:out value='${registro[1]}'/>" size=40></td></tr>
        <tr><th>Login: </th>
            <td><input name=xlog value="<c:out value='${registro[2]}'/>" size=15></td></tr>
        <tr><th>Clave: </th>
            <td><input type="password" name=cla1 value="" size=15></td></tr>
        <tr><th>Redigite clave: </th>
            <td><input type="password" name=cla2 value="" size=15></td></tr>
        <tr><th>Tipo: </th>
            <td><input name=xtip value="<c:out value='${registro[3]}'/>" size=5></td></tr>
        <tr><th>Estado:</th>
            <td><c:choose>
                  <c:when test="${registro[3]=='X'}">
                      <input type=radio name=xest value=A>Activo
                      <input type=radio name=xest value=X checked>Inactivo
                  </c:when>
                  <c:otherwise>
                      <input type=radio name=xest value=A checked>Activo
                      <input type=radio name=xest value=X>Inactivo
                  </c:otherwise>
                </c:choose>
            </td></tr>
     </table>
     <br>
     <input type=submit name=boton value="GRABAR">
     <input type=submit name=boton value="CANCELAR">
   </form>
</div>
