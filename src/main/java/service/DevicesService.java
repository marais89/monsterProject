package service;

import java.util.List;

import model.Devices;


public interface DevicesService {
	
	public void addDevice(Devices device);

	public void updateDevice(Devices device);

	public void deleteDevice(Devices device);

	public List<Devices> findAllDevices();

}
