/**
 * 
 */
package service;

import java.util.List;

import model.Actions;

/**
 * @author ma.raies
 * 4 janv. 2016 11:55:52
 */
public interface ActionsService {
	
	public void addActions(Actions actions);

	public void updateActions(Actions actions);

	public void deleteActions(Actions actions);

	public List<Actions> findAllActions();
	
	public List<Actions> findAllAFaire();

}
