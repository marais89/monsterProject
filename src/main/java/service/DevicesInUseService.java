/**
 * 
 */
package service;

import java.util.List;

import model.Devicesinuse;

/**
 * @author ma.raies
 * 25 août 2016 15:32:57
 */
public interface DevicesInUseService {
	
	public void addDevice(Devicesinuse diuse);

	public void updateDevice(Devicesinuse diuse);

	public void deleteDevice(Devicesinuse diuse);

	public List<Devicesinuse> findAllDevices();

}
