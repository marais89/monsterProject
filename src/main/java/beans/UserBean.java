package beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import model.Actions;
import model.Participation;
import model.ParticipationId;
import model.Reunion;
import model.Users;
import service.ActionsService;
import service.ParticipationService;
import service.ReunionService;
import service.UsersService;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SessionScoped
@ManagedBean
public class UserBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private Users user;
	private Actions action;
	private Reunion reunion;
	private Participation participation;
	private List<Reunion> listeReunion;
	private List<Participation> listeParticipation;
	private List<Users> listUsers;
	private String login = "";
	private String passwd = "";
	private List<Actions> listActions;
	private List<Actions> listAFaire;
	private Actions selectedAction;
	private DualListModel<Users> dualListUser;
	private int duree=10;
	private int increment=0;
	private int pourcentage=0;
	private String photo="/resources/images/line.jpg";
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@ManagedProperty(value = ("#{usersServiceImpl}"))
	private UsersService usersService;
	@ManagedProperty(value = ("#{actionsServiceImpl}"))
	private ActionsService actionsService;

	@ManagedProperty(value = ("#{reunionServiceImpl}"))
	private ReunionService reunionService;

	@ManagedProperty(value = ("#{participationServiceImpl}"))
	private ParticipationService participationService;

	public UserBean() {
	}

	@PostConstruct
	public void init() {
		this.user = new Users();
		this.action = new Actions();
		this.reunion=new Reunion();
		this.listUsers = usersService.findAllUsers();
		this.listAFaire = actionsService.findAllAFaire();
		this.listActions = actionsService.findAllActions();
		this.listeParticipation = participationService.findAllParticipation();
		this.listeReunion = reunionService.findAllReunion();
		 List<Users> usersTarget = new ArrayList<Users>();         
		 dualListUser = new DualListModel<Users>(listUsers, usersTarget);
	         
	}

	public void onRowEdit(RowEditEvent event) {
		try {

			usersService.updateUsers((Users) event.getObject());
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
				((Users) event.getObject()).getFirstName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void ajouterReunion() {
		try{
		Date dateActuel = new Date();
		this.reunion.setDateReunion(dateActuel);
		reunionService.addReunion(reunion);
		for(int i=0;i<dualListUser.getTarget().size();i++){
			Participation part = new Participation();
			ParticipationId partId = new ParticipationId(dualListUser.getTarget().get(i).getUserId(),reunion.getReunionId());
			part.setParticipationId(partId);
			part.setDuree(0);
			participationService.addParticipation(part);}
		FacesMessage msg = new FacesMessage("Démarrage de réunion ...");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		incrementduree();
		}catch (Exception e) {
			FacesMessage msg = new FacesMessage("Erreur");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			e.getMessage();
			
		}		
	}
	
	public void incrementduree(){
		int leTempsEnMillisecondes=1000;
		for(int i=0;i<dualListUser.getTarget().size();i++){
			increment=0;
			pourcentage=0;
			  this.photo=convertToFile(dualListUser.getTarget().get(i));
			  this.user=dualListUser.getTarget().get(i);
			  for(int j=0;j<duree;j++){
		            try {
		                Thread.sleep (leTempsEnMillisecondes);
		            } 
		            catch (InterruptedException e) {
		                System.out.print("** erreur in timer ");
		            }
		            increment++;
		            pourcentage=(increment*100)/duree;
			  } 
		}		
	}
	
	

	public void deleteaction() {
		try {
			actionsService.deleteActions(selectedAction);
			FacesMessage msg = new FacesMessage(
					"L'action a étè supprimé avec succées");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Erreur");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			e.getMessage();
		}
	}

	public void ajouterUser() {
		try {
			user.setRole("admin");
			user.setStat("active");
			user.setPassword(encoder.encode(this.user.getPassword()));
			usersService.addUser(user);
			FacesMessage msg = new FacesMessage(
					"utilisateur ajouté avec succées");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			this.user = new Users();
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Erreur");
			System.out.println("### votre erreur est : "+e);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			e.getMessage();
		}
		System.out.println("ajout user test test ...");
	}

	public void handleFileUpload(FileUploadEvent event) {

		user.setPhoto(event.getFile().getContents());
	}

	public void handleFileUploadupdate(FileUploadEvent event) {

		user.setPhoto(event.getFile().getContents());
	}

	public void ajouterAction(String str) {
		try {
			Date dateActuel = new Date();
			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(dateActuel);
			action.setCreationDate(calendar1.getTime());
			if (action.getRealization_date() == null) {
				this.action.setRealization_date(this.action.getCreationDate());
			}
			if (str.equals("1")) {
				action.setType("afaire");
			} else {
				action.setType("action");
			}
			actionsService.addActions(action);
			FacesMessage msg = new FacesMessage("element ajouté avec succées");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			this.action = new Actions();

		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Erreur");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			e.getMessage();
		}
	}

	public void test() {
		System.out.println("test tes test ...");
	}

	public String convertToFile(Users p) {
		String PhotoName = p.getFirstName() + "" + p.getLastName();
		if (p.getPhoto() != null) {
			System.out.println("######### photo "+p.getPhoto());
			try {
				ExternalContext externalContext = FacesContext
						.getCurrentInstance().getExternalContext();
				String relativeWebPath = "/resources/tmp/";
				ServletContext servletContext = (ServletContext) externalContext
						.getContext();
				String absoluteDiskPath = servletContext
						.getRealPath(relativeWebPath);
				File file = new File(absoluteDiskPath + "/" + PhotoName);
				file.createNewFile();
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(p.getPhoto());
				fos.close();

				return "/resources/tmp/" + PhotoName;
			} catch (Exception e) {
				e.printStackTrace();
				return "/resources/images/line.jpg";
			}
		} else
			return "/resources/images/line.jpg";
	}
	
	 public void onTransfer(TransferEvent event) {
	        StringBuilder builder = new StringBuilder();
	        for(Object item : event.getItems()) {
	            builder.append(((Users) item).getFirstName()).append("<br />");
	        }
	         
	        FacesMessage msg = new FacesMessage();
	        msg.setSeverity(FacesMessage.SEVERITY_INFO);
	        msg.setSummary("Items Transferred");
	        msg.setDetail(builder.toString());
	         
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    } 
	 
	    public void onSelect(SelectEvent event) {
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
	    }
	     
	    public void onUnselect(UnselectEvent event) {
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
	    }
	     
	    public void onReorder() {
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
	    } 

	// ////////////////////////// GETTERS AND SETTERS //
	// ///////////////////////////
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Users> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<Users> listUsers) {
		this.listUsers = listUsers;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public List<Actions> getListActions() {
		this.listActions = actionsService.findAllActions();
		return listActions;
	}

	public void setListActions(List<Actions> listActions) {
		this.listActions = listActions;
	}

	public ActionsService getActionsService() {
		return actionsService;
	}

	public void setActionsService(ActionsService actionsService) {
		this.actionsService = actionsService;
	}

	public Actions getSelectedAction() {
		return selectedAction;
	}

	public void setSelectedAction(Actions selectedAction) {
		this.selectedAction = selectedAction;
	}

	public Actions getAction() {
		return action;
	}

	public void setAction(Actions action) {
		this.action = action;
	}

	public List<Actions> getListAFaire() {
		this.listAFaire = actionsService.findAllAFaire();
		return listAFaire;
	}

	public void setListAFaire(List<Actions> listAFaire) {
		this.listAFaire = listAFaire;
	}

	public List<Reunion> getListeReunion() {
		return listeReunion;
	}

	public void setListeReunion(List<Reunion> listeReunion) {
		this.listeReunion = listeReunion;
	}

	public List<Participation> getListeParticipation() {
		return listeParticipation;
	}

	public void setListeParticipation(List<Participation> listeParticipation) {
		this.listeParticipation = listeParticipation;
	}

	public ReunionService getReunionService() {
		return reunionService;
	}

	public void setReunionService(ReunionService reunionservice) {
		this.reunionService = reunionservice;
	}

	public ParticipationService getParticipationService() {
		return participationService;
	}

	public void setParticipationService(
			ParticipationService participationService) {
		this.participationService = participationService;
	}

	public Reunion getReunion() {
		return reunion;
	}

	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}

	public Participation getParticipation() {
		return participation;
	}

	public void setParticipation(Participation participation) {
		this.participation = participation;
	}

	public DualListModel<Users> getDualListUser() {
		return dualListUser;
	}

	public void setDualListUser(DualListModel<Users> dualListUser) {
		this.dualListUser = dualListUser;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getIncrement() {
		return increment;
	}

	public void setIncrement(int increment) {
		this.increment = increment;
	}

	public int getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(int pourcentage) {
		this.pourcentage = pourcentage;
	}
	
	
	
}
