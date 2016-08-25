/**
 * 
 */
package dao;

import java.util.List;

import model.Devicesinuse;

/**
 * @author ma.raies
 * 25 août 2016 14:57:58
 */
public interface DevicesinuseDao {
	
	public void addDevicesinuse(Devicesinuse diuse);

	public void updateDevicesinuse(Devicesinuse diuse);

	public void deleteDevicesinuse(Devicesinuse diuse);

	public List<Devicesinuse> findAllDevicesinuse();

}
