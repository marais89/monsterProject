/**
 * 
 */
package service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.*;
import dao.*;

/**
 * @author ma.raies
 * 
 */
@Service
public class UsersServiceImpl implements UsersService, Serializable {

	@Autowired
	private UsersDao usersDao;

	@Override
	@Transactional
	public void addUser(Users user) {
		usersDao.addUser(user);
	}

	@Override
	@Transactional
	public void updateUsers(Users user) {
		usersDao.updateUsers(user);
	}

	@Override
	@Transactional
	public void deleteUsers(Users user) {
		usersDao.deleteUsers(user);
	}

	@Override
	@Transactional
	public List<Users> findAllUsers() {
		return usersDao.findAllUsers();
	}
	
	@Override
	@Transactional
	public Users getUserByLogin(String login){
		return usersDao.getUserByLogin(login);
	}

	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

}
