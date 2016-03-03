package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Reunion;
import model.Users;

@Repository
public class ReunionDaoImpl implements ReunionDao,Serializable {

	
	@Autowired
	private SessionFactory session;

	public SessionFactory getSession() {
		return session;
	}
	
	public void setSession(SessionFactory session) {
		this.session = session;
	}
	
	@Override
	public void addReunion(Reunion reunion) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(reunion);
	}

	@Override
	public void updateReunion(Reunion reunion) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(reunion);
	}

	@Override
	public void deleteReunion(Reunion reunion) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(reunion);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reunion> findAllReunion() {
		List l = new ArrayList<Users>();
		l = session.getCurrentSession().createQuery("from Reunion").list();
		return l;
	}

}
