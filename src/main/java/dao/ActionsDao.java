/**
 * 
 */
package dao;

import java.util.List;

import model.Actions;

/**
 * @author ma.raies
 * 4 janv. 2016 12:01:21
 */
public interface ActionsDao {
	public void addActions(Actions action);

	public void updateActions(Actions action);

	public void deleteActions(Actions action);

	public List<Actions> findAllActions();
	
	public List<Actions> findAllAFaire();
}
