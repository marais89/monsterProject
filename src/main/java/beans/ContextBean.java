/**
 * 
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DualListModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import service.UsersService;
import model.Actions;
import model.Reunion;
import model.Users;

/**
 * @author ma.raies
 * 29 janv. 2016 11:02:38
 */
@SessionScoped
@ManagedBean
public class ContextBean implements Serializable {
	
	private String content ="/pages/home.xhtml";
	private String nomUtilisateur="Mohamed Ali";
	private Users connectedUser;
	private boolean bolSign=true;
	
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String name = auth.getName(); //get logged in username
	
	
	@ManagedProperty(value = ("#{usersServiceImpl}"))
	private UsersService usersService;
	
	
	@PostConstruct
	public void init() {
		this.connectedUser = new Users();
		//this.connectedUser=usersService
		
	         
	}
	
	public void  changeBolSign(){
		this.bolSign=!this.bolSign;
	}
	
	
	public void test(){
		System.out.println("your validation login is excecuted ...");
		System.out.println("login"+connectedUser.getEmail());
		System.out.println("password"+connectedUser.getPassword());
	}
	
	
	
	
	
	////////////////////// GETTERS AND SETTERS //////////////////
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public Users getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(Users connectedUser) {
		this.connectedUser = connectedUser;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public boolean isBolSign() {
		return bolSign;
	}

	public void setBolSign(boolean bolSign) {
		this.bolSign = bolSign;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
