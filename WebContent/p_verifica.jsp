<%@ page import="java.util.*" %>
<%@page import="controller.cUsuario" %>

<%
 String xlog = request.getParameter("xlogin");
 String xcla = request.getParameter("xclave");
 cUsuario objUsuario = new cUsuario();

 if ( objUsuario.existeUsuario(xlog, xcla) ) {
    session.setAttribute( "codigo", xlog );
    session.setAttribute( "clave" , xcla );
    response.sendRedirect( "entorno.jsp");
 }
 else {
    response.sendRedirect( "index.jsp");
 }
%>