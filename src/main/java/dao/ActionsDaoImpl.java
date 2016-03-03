/**
 * 
 */
package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Actions;
import model.Users;

/**
 * @author ma.raies
 * 4 janv. 2016 12:03:27
 */
@Repository
public class ActionsDaoImpl implements ActionsDao ,Serializable {

	/* (non-Javadoc)
	 * @see dao.ActionsDao#addActions(model.Actions)
	 */
	
	@Autowired
	private SessionFactory session;

	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}
	
	@Override
	public void addActions(Actions action) {
		session.getCurrentSession().save(action);

	}

	/* (non-Javadoc)
	 * @see dao.ActionsDao#updateActions(model.Actions)
	 */
	@Override
	public void updateActions(Actions action) {
		session.getCurrentSession().update(action);
	}

	/* (non-Javadoc)
	 * @see dao.ActionsDao#deleteActions(model.Actions)
	 */
	@Override
	public void deleteActions(Actions action) {
		session.getCurrentSession().delete(action);
	}

	/* (non-Javadoc)
	 * @see dao.ActionsDao#findAllActions()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Actions> findAllActions() {
		List l = new ArrayList<Actions>();
		l = session.getCurrentSession().createQuery("from Actions where type='action' and stat='false'").list();
		return l;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Actions> findAllAFaire() {
		List l = new ArrayList<Actions>();
		l = session.getCurrentSession().createQuery("from Actions where type='afaire' and stat='false'").list();
		return l;
	}
}
