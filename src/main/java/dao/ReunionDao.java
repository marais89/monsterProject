package dao;

import java.util.List;

import model.Reunion;

public interface ReunionDao {
	
	public void addReunion(Reunion reunion);

	public void updateReunion(Reunion reunion);

	public void deleteReunion(Reunion reunion);

	public List<Reunion> findAllReunion();

}
