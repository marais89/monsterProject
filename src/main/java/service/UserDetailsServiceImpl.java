package service;

import java.io.Serializable;

import model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dao.UsersDao;

@Component
public class UserDetailsServiceImpl implements UserDetailsService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UsersDao userDao;

	public Assembler getAssembler() {
		return assembler;
	}

	public void setAssembler(Assembler assembler) {
		this.assembler = assembler;
	}

	@Autowired
	private Assembler assembler;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException, DataAccessException {

	

		Users u = userDao.getUserByLogin(login);
	try{	
		if (u == null)
			throw new UsernameNotFoundException("user not found");
	} catch (Exception e) {
		System.out.println("########## login or password incorrect !");
	}
		return assembler.buildUserFromUserEntity(u);
		
	}

	public UsersDao getuserDao() {
		return userDao;
	}

	public void setuserDao(UsersDao userDao) {
		this.userDao = userDao;
	}
}
