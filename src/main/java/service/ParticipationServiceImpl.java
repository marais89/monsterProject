package service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ActionsDao;
import dao.ParticipationDao;
import model.Participation;

@Service
public class ParticipationServiceImpl implements ParticipationService,Serializable {

	@Autowired
	private ParticipationDao participationDao;
	
	@Override
	@Transactional
	public void addParticipation(Participation participation) {
		// TODO Auto-generated method stub
		participationDao.addParticipation(participation);
	}

	@Override
	@Transactional
	public void updateParticipation(Participation participation) {
		// TODO Auto-generated method stub
		participationDao.updateParticipation(participation);
	}

	@Override
	@Transactional
	public void deleteParticipation(Participation participation) {
		// TODO Auto-generated method stub
		participationDao.deleteParticipation(participation);
	}

	@Override
	@Transactional
	public List<Participation> findAllParticipation() {
		// TODO Auto-generated method stub
		return participationDao.findAllParticipation();
	}

	public ParticipationDao getParticipationDao() {
		return participationDao;
	}

	public void setParticipationDao(ParticipationDao participationDao) {
		this.participationDao = participationDao;
	}
	
	

}
