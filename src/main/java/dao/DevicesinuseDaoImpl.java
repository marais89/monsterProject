/**
 * 
 */
package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import model.Devices;
import model.Devicesinuse;

/**
 * @author ma.raies
 * 25 août 2016 15:01:39
 */
public class DevicesinuseDaoImpl implements DevicesinuseDao, Serializable {

	@Autowired
	private SessionFactory session;

	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}
	
	@Override
	public void addDevicesinuse(Devicesinuse diuse) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(diuse);
	}

	/* (non-Javadoc)
	 * @see dao.DevicesinuseDao#updateDevicesinuse(model.Devicesinuse)
	 */
	@Override
	public void updateDevicesinuse(Devicesinuse diuse) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(diuse);
	}

	/* (non-Javadoc)
	 * @see dao.DevicesinuseDao#deleteDevicesinuse(model.Devicesinuse)
	 */
	@Override
	public void deleteDevicesinuse(Devicesinuse diuse) {
		// TODO Auto-generated method stub
			session.getCurrentSession().delete(diuse);
	}

	/* (non-Javadoc)
	 * @see dao.DevicesinuseDao#findAllDevicesinuse()
	 */
	@Override
	public List<Devicesinuse> findAllDevicesinuse() {
		List<Devicesinuse> l = new ArrayList<Devicesinuse>();
		l = session.getCurrentSession().createQuery("from Devicesinuse").list();
		return l;
	}

}
