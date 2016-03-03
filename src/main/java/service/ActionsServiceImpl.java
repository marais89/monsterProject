/**
 * 
 */
package service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ActionsDao;
import dao.UsersDao;
import model.Actions;

/**
 * @author ma.raies
 * 4 janv. 2016 11:57:00
 */
@Service
public class ActionsServiceImpl implements ActionsService, Serializable {

	/* (non-Javadoc)
	 * @see service.ActionsService#addActions(model.Actions)
	 */
	@Autowired
	private ActionsDao actionsDao;
	
	@Override
	@Transactional
	public void addActions(Actions actions) {
		actionsDao.addActions(actions);
	}

	/* (non-Javadoc)
	 * @see service.ActionsService#updateActions(model.Actions)
	 */
	@Override
	@Transactional
	public void updateActions(Actions actions) {
		actionsDao.updateActions(actions);

	}

	/* (non-Javadoc)
	 * @see service.ActionsService#deleteActions(model.Actions)
	 */
	@Override
	@Transactional
	public void deleteActions(Actions actions) {
		actionsDao.deleteActions(actions);
	}

	/* (non-Javadoc)
	 * @see service.ActionsService#findAllActions()
	 */
	@Override
	@Transactional
	public List<Actions> findAllActions() {	
		return actionsDao.findAllActions();
	}
	
	@Override
	@Transactional
	public List<Actions> findAllAFaire() {	
		return actionsDao.findAllAFaire();
	}

	public ActionsDao getActionsDao() {
		return actionsDao;
	}

	public void setActionsDao(ActionsDao actionsDao) {
		this.actionsDao = actionsDao;
	}
	
	

}
