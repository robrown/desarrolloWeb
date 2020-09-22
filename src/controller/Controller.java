package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import modelDAO.UserDAO;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	String listar = "listar.jsp";
	String add = "add.jsp";
	String edit = "edit.jsp";
	User usuario = new User();
	UserDAO dao = new UserDAO();
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acceso = "";
		String action=request.getParameter("accion");
		
		if (action.equalsIgnoreCase("listar")) {
			acceso=listar;
		}else if(action.equalsIgnoreCase("add")) {
			acceso = add;
		}else if(action.equalsIgnoreCase("Agregar")) {
			String user = request.getParameter("txtUserName");
			String pass = request.getParameter("txtPassword");
			String name = request.getParameter("txtName");
			String last_o = request.getParameter("txtLastOne");
			String last_t = request.getParameter("txtLastTwo");
			String dni = request.getParameter("txtDni");
			usuario.setUser_name(user);
			usuario.setPassword(pass);
			usuario.setName(name);
			usuario.setLast_name_one(last_o);
			usuario.setLast_name_two(last_t);
			usuario.setDni(dni);
			dao.add(usuario);
			acceso = listar;
		}
		RequestDispatcher vista=request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
