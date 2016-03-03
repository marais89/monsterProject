/**
 * 
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.UsersDao;
import model.*;

/**
 * @author ma.raies
 * 
 */
@Repository
public class UsersDaoImpl implements UsersDao {

	@Autowired
	private SessionFactory session;

	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}

	@Override
	public void addUser(Users user) {
		session.getCurrentSession().save(user);
	}

	@Override
	public void updateUsers(Users user) {
		session.getCurrentSession().update(user);
	}

	@Override
	public void deleteUsers(Users user) {
		session.getCurrentSession().delete(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> findAllUsers() {
		List l = new ArrayList<Users>();
		l = session.getCurrentSession().createQuery("from Users").list();
		return l;
	}
	
	@Override
	public Users getUserByLogin(String login){		
		Users user = new Users();
		Query query=session.getCurrentSession().createQuery("from Users where email =:login").setParameter("login", login);
		return (Users)query.list().get(0);		
	}

}
