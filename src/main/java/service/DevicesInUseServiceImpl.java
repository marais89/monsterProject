/**
 * 
 */
package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import dao.DevicesinuseDao;
import model.Devicesinuse;

/**
 * @author ma.raies
 * 25 août 2016 15:36:51
 */
public class DevicesInUseServiceImpl implements DevicesInUseService {

	
	@Autowired
	private DevicesinuseDao diuseDao;
	
	@Override
	@Transactional
	public void addDevice(Devicesinuse diuse) {
		diuseDao.addDevicesinuse(diuse);

	}

	/* (non-Javadoc)
	 * @see service.DevicesInUseService#updateDevice(model.Devicesinuse)
	 */
	@Override
	@Transactional
	public void updateDevice(Devicesinuse diuse) {
		diuseDao.updateDevicesinuse(diuse);

	}

	/* (non-Javadoc)
	 * @see service.DevicesInUseService#deleteDevice(model.Devicesinuse)
	 */
	@Override
	@Transactional
	public void deleteDevice(Devicesinuse diuse) {
		diuseDao.deleteDevicesinuse(diuse);

	}

	/* (non-Javadoc)
	 * @see service.DevicesInUseService#findAllDevices()
	 */
	@Override
	@Transactional
	public List<Devicesinuse> findAllDevices() {
		
		return diuseDao.findAllDevicesinuse();
	}

	public DevicesinuseDao getDiuseDao() {
		return diuseDao;
	}

	public void setDiuseDao(DevicesinuseDao diuseDao) {
		this.diuseDao = diuseDao;
	}
	
	

}
