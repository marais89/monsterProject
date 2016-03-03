package service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ActionsDao;
import dao.ReunionDao;
import model.Reunion;

@Service
public class ReunionServiceImpl implements ReunionService,Serializable {

	@Autowired
	private ReunionDao reunionDao;
	
	@Override
	@Transactional
	public void addReunion(Reunion reunion) {
		// TODO Auto-generated method stub
		reunionDao.addReunion(reunion);
	}

	@Override
	@Transactional
	public void updateReunion(Reunion reunion) {
		// TODO Auto-generated method stub
		reunionDao.updateReunion(reunion);
	}

	@Override
	@Transactional
	public void deleteReunion(Reunion reunion) {
		// TODO Auto-generated method stub
		reunionDao.deleteReunion(reunion);
	}

	@Override
	@Transactional
	public List<Reunion> findAllReunion() {
		// TODO Auto-generated method stub
		return reunionDao.findAllReunion();
	}

	public ReunionDao getReunionDao() {
		return reunionDao;
	}

	public void setReunionDao(ReunionDao reunionDao) {
		this.reunionDao = reunionDao;
	}
	
	

}
