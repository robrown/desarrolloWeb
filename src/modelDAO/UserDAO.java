package modelDAO;

import java.sql.*;
import java.util.*;

import config.Conexion;
import interfaces.CRUD;
import model.User;

public class UserDAO implements CRUD{
	Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public List<User> listar() {
		ArrayList<User>lista = new ArrayList<>();
		String sql="select * from users";
		try {
			con=cn.getConexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println(rs.next());
			System.out.println(rs.getNString("name"));
			while(rs.next()) {
				User usuario = new User();
				usuario.setName(rs.getNString("name"));
				usuario.setLast_name_one(rs.getNString("last_name_one"));
				usuario.setLast_name_two(rs.getNString("last_name_two"));
				usuario.setUser_name(rs.getNString("user_name"));
				usuario.setDni(rs.getNString("dni"));
				System.out.println(usuario);
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
		String sql = "insert into users(name,last_one,last_two,user_name,password,dni)values('" +
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
