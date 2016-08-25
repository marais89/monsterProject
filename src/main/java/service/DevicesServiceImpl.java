/**
 * 
 */
package service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DevicesDao;
import model.Devices;

/**
 * @author ma.raies
 * 8 août 2016 15:33:47
 */
@Service
public class DevicesServiceImpl implements DevicesService, Serializable {

	@Autowired
	private DevicesDao devicesDao;
	
	@Override
	@Transactional
	public void addDevice(Devices device) {
		devicesDao.addDevice(device);

	}

	@Override
	@Transactional
	public void updateDevice(Devices device) {
		devicesDao.updateDevice(device);

	}

	@Override
	@Transactional
	public void deleteDevice(Devices device) {
		devicesDao.updateDevice(device);

	}

	@Override
	@Transactional
	public List<Devices> findAllDevices() {
		System.out.println("avant ...");
		List<Devices>l= devicesDao.findAllDevices();
		System.out.println("apres ...");
		return l;
	}

	public DevicesDao getDevicesDao() {
		return devicesDao;
	}

	public void setDevicesDao(DevicesDao devicesDao) {
		this.devicesDao = devicesDao;
	}
	
	

}
