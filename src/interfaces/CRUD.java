package interfaces;

import java.util.List;

import model.User;

public interface CRUD {
	public List<User> listar();
	public User list(int id);
	public boolean add(User usuario);
	public boolean edir(User usuario);
	public boolean delete(int id);
}
