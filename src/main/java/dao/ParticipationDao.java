package dao;

import java.util.List;

import model.Participation;

public interface ParticipationDao {
	
	public void addParticipation(Participation participation);

	public void updateParticipation(Participation participation);

	public void deleteParticipation(Participation participation);

	public List<Participation> findAllParticipation();

}
