/**
 * 
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DualListModel;

import service.DevicesService;
import model.Devices;
import model.Users;

/**
 * @author ma.raies
 * 8 août 2016 14:04:57
 */
@SessionScoped
@ManagedBean
public class DeviceBean implements Serializable{
	
	private Devices device;
	private List<Devices> listDevices;
	
	
	@ManagedProperty(value = ("#{devicesServiceImpl}"))
	private DevicesService devicesService;
	
	@PostConstruct
	public void init() {
		this.device=new Devices();
		 this.listDevices  = devicesService.findAllDevices();      
		         
	}
	
	public void onRowEdit(RowEditEvent event) {
		try {
			devicesService.updateDevice((Devices) event.getObject());
			FacesMessage msg = new FacesMessage(
					"Modification effectué avec succées");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Erreur");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			e.getMessage();
		}
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Modification annulé",
				((Devices) event.getObject()).getNom());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Devices getDevice() {
		return device;
	}

	public void setDevice(Devices device) {
		this.device = device;
	}

	public List<Devices> getListDevices() {
		return listDevices;
	}

	public void setListDevices(List<Devices> listDevices) {
		this.listDevices = listDevices;
	}

	public DevicesService getDevicesService() {
		return devicesService;
	}

	public void setDevicesService(DevicesService devicesService) {
		this.devicesService = devicesService;
	}	

}
