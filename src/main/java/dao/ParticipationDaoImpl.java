package dao;

import java.util.ArrayList;
import java.util.List;

import model.Participation;
import model.Users;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ParticipationDaoImpl implements ParticipationDao {

	
	@Autowired
	private SessionFactory session;

	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}
	
	@Override
	public void addParticipation(Participation participation) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(participation);
	}

	@Override
	public void updateParticipation(Participation participation) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(participation);
	}

	@Override
	public void deleteParticipation(Participation participation) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(participation);
	}

	@Override
	public List<Participation> findAllParticipation() {
		List l = new ArrayList<Users>();
		l = session.getCurrentSession().createQuery("from Participation").list();
		return l;
	}

}
