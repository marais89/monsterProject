/**
 * 
 */
package service;

import java.util.List;

import model.*;

/**
 * @author ma.raies
 * 
 */
public interface UsersService {

	public void addUser(Users user);

	public void updateUsers(Users user);

	public void deleteUsers(Users user);

	public List<Users> findAllUsers();
	
	public Users getUserByLogin(String login);

}
