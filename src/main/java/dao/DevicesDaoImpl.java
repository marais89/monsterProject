/**
 * 
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Devices;
import model.Users;

/**
 * @author ma.raies
 * 8 août 2016 15:20:34
 */
@Repository
public class DevicesDaoImpl implements DevicesDao {

	@Autowired
	private SessionFactory session;

	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}
	/* (non-Javadoc)
	 * @see dao.DevicesDao#addDevice(model.Devices)
	 */
	@Override
	public void addDevice(Devices device) {
		session.getCurrentSession().save(device);

	}

	/* (non-Javadoc)
	 * @see dao.DevicesDao#updateDevice(model.Devices)
	 */
	@Override
	public void updateDevice(Devices device) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(device);

	}

	/* (non-Javadoc)
	 * @see dao.DevicesDao#deleteDevice(model.Devices)
	 */
	@Override
	public void deleteDevice(Devices device) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(device);

	}

	/* (non-Javadoc)
	 * @see dao.DevicesDao#findAllDevices()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Devices> findAllDevices() {
System.out.println("avant dao");
		List<Devices> l = new ArrayList<Devices>();
		l = session.getCurrentSession().createQuery("from Devices").list();
		System.out.println("apres dao...");
		return l;
	}

}
