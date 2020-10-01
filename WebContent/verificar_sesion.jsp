<%
  String login = (String)session.getAttribute( "codigo" );
  if ( login == null )
  {
      response.sendRedirect( "/AppWebCC/index.jsp" );
      return;
  }
%>
