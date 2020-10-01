<%@ page import="controller.*" %>
<%@ page import="java.util.*" %>
<%@include file="/verificar_sesion.jsp" %>
<%
 cUsuario objUsuario = new cUsuario();
 String accion = request.getParameter("accion");
 if ( accion == null )
    accion = "LISTADO";

 if ( accion.compareTo( "LISTADO" ) == 0) {
    Vector arrData = (Vector)objUsuario.getRegistros();
    request.setAttribute( "arrData", arrData );
    request.getRequestDispatcher( "m_usuarios_listado_tpl.jsp" ).forward( request,response );
 } else if ( accion.compareTo( "MODIFICAR_REGISTRO" ) == 0 ) {
    String xcod = request.getParameter( "xcod" );
    Vector registro = objUsuario.getRegistro(xcod);

    request.setAttribute( "registro", registro );
    request.setAttribute( "operacion","UPDATE");
    request.setAttribute( "titulo","Modificar Usuario");
    request.getRequestDispatcher( "m_usuarios_editar_tpl.jsp" ).forward( request,response );
 } else if ( accion.compareTo( "GRABAR_REGISTRO") == 0 ) {
    if ( request.getParameter( "boton" ).compareTo( "GRABAR" ) == 0 ) {
        String operacion = request.getParameter("operacion");
        if ( operacion.equals("UPDATE")) {
            String[] datos = {
                request.getParameter("xcod"),
                request.getParameter("xnom"),
                request.getParameter("xlog"),
                request.getParameter("xtip"),
                request.getParameter("xest"),
                request.getParameter("cla1"),
                request.getParameter("cla2") };
            objUsuario.grabarModificarRegistro( datos );
        }
        else {
            String[] datos = {
                request.getParameter("xnom"),
                request.getParameter("xlog"),
                request.getParameter("xtip"),
                request.getParameter("xest"),
                request.getParameter("cla1"),
                request.getParameter("cla2") };
            objUsuario.grabarNuevoRegistro( datos );
        }
    }
    response.sendRedirect("m_usuarios_controller.jsp");
 }  else if ( accion.compareTo( "NUEVO_ELIMINAR_REGISTRO" ) == 0 ) {
        if ( request.getParameter( "boton" ).compareTo( "Nuevo Registro") == 0 ) {
            Vector registro = new Vector();
            registro.add("");
            registro.add("");
            registro.add("");
            registro.add("");
            registro.add("");
            registro.add("");

            request.setAttribute( "registro", registro );
            request.setAttribute( "operacion","INSERT");
            request.setAttribute( "titulo","Nuevo Usuario");
            request.getRequestDispatcher( "m_usuarios_editar_tpl.jsp" ).forward( request,response );
        }
        else {
           String[] datos = request.getParameterValues("xcod");
           objUsuario.eliminarRegistros( datos );
           response.sendRedirect("m_usuarios_controller.jsp");
        }
 }
%>
