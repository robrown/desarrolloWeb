package modelDAO;

import java.sql.*;
import java.util.*;

import config.cBaseDatos;
import interfaces.CRUD;
import model.User;

public class UserDAO implements CRUD{
	cBaseDatos cn = new cBaseDatos();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public List<User> listar() {
		ArrayList<User>lista = new ArrayList<>();
		String sql="select * from auth_user";
		try {
			con=cn.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			//System.out.println(rs.next());
			System.out.println(rs.getString("username"));
			while(rs.next()) {
				User usuario = new User();
				usuario.setName(rs.getString("username"));
				usuario.setLast_name_one(rs.getString("email"));
				usuario.setLast_name_two(rs.getString("date_joined"));
				usuario.setUser_name(rs.getString("user_name"));
				usuario.setDni(rs.getString("dni"));
				System.out.println("No entra");
				lista.add(usuario);
			}
			
		}catch (Exception e) {
			
		}
		return lista;
	}

	@Override
	public User list(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(User usuario) {
		String sql = "insert into auth_user(name,last_one,last_two,user_name,password,dni)values('" +
				usuario.getName() + "','" + usuario.getLast_name_one() + "','" + usuario.getLast_name_two() +
				usuario.getUser_name() + "','" + usuario.getPassword() + "','" + usuario.getDni() + "')";
		try {
			con=cn.getConexion();
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("Error al insertar el usuario." + e);
		}
		return false;
	}

	@Override
	public boolean edir(User usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
