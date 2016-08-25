/**
 * 
 */
package dao;

import java.util.List;

import model.Devices;

/**
 * @author ma.raies
 * 8 août 2016 15:17:05
 */
public interface DevicesDao {
	
	public void addDevice(Devices device);

	public void updateDevice(Devices device);

	public void deleteDevice(Devices device);

	public List<Devices> findAllDevices();

}
