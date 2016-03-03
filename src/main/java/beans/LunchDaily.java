package beans;

import javax.faces.bean.ManagedProperty;

import org.primefaces.context.RequestContext;

import service.ParticipationService;

public class LunchDaily extends Thread {
	
	
	@ManagedProperty(value = ("#{userBean}"))
	private UserBean userBean;

	public void run(){
		int leTempsEnMillisecondes=1000;
		for(int i=0;i<userBean.getDualListUser().getTarget().size();i++){
		        for (int j=userBean.getDuree();j>=0;j--) {
		            try {
		                Thread.sleep (leTempsEnMillisecondes);
		            } 
		            catch (InterruptedException e) {
		                System.out.print("** erreur in timer ");
		            }
		            userBean.setIncrement(userBean.getIncrement()+1);
		    
		            RequestContext.getCurrentInstance().update("formCenter:imageReunion");
		            RequestContext.getCurrentInstance().update("formCenter");
		        }
		        userBean.setPhoto(userBean.convertToFile(userBean.getDualListUser().getTarget().get(i)));
		        RequestContext.getCurrentInstance().update("formCenter:imageReunion");
		}		
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	
	
}
