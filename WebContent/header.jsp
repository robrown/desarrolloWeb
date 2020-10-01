<%
  String login = (String)session.getAttribute( "codigo" );
  if ( login == null )
      response.sendRedirect( "index.jsp" );
%>

<html>
    <head>
        <title>JSP Header</title>
        <link href="css/estilo.css" type="text/css" rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="js/menu/menu.css">
        <script type="text/javascript" src="js/menu/menu.js"></script>
        <script type="text/javascript" src="js/menu/menu_tpl.js"></script>
        <script type="text/javascript" src="js/calendario.js"></script>

        <script type="text/javascript" src="js/popup/popup.js"></script>

        <script>
            var MENU_ITEMS = [ ['Mantenimiento', null, null ,
                                 ['Areas','mantenimientos/m_areas_controller.jsp'],
                                 ['Alumnos','mantenimientos/m_alumnos_controller.jsp'],
                                 ['Docentes','mantenimientos/m_docentes_controller.jsp'],
                                 ['Cursos','mantenimientos/m_cursos_controller.jsp'],
                                 ['Usuarios','mantenimientos/m_usuarios_controller.jsp']
                     ],
                     ['Procesos', null, null ,
                                  ['Matriculas','procesos/p_matriculas_controller.jsp'],
                                  ['Anulaciones','procesos/p_anulacion_controller.jsp'],
                     ],
                     ['Reportes', null, null ,
                                  ['Areas','#'],
                                  ['Alumnos','reportes/r_alumnos_sexo_controller.jsp'],
                                  ['R 3','#'],
                                  ['R 4','#']
                     ]
                   ];
         </script>
    </head>
<body>
  <div id="encabezado">
      <div id="titulos">
           CONTROL CAPACITACION CONTINUA
      </div>
      <div id="logo">
          <img id="logo" src="img/logo.gif" />
      </div>
  </div>

  <div id="subtitulo">
    <script >
      new menu (MENU_ITEMS, MENU_POS);
    </script>
  </div>