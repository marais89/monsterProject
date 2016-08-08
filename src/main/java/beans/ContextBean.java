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
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import service.UsersService;
import model.Actions;
import model.Reunion;
import model.Users;

/**
 * @author ma.raies 29 janv. 2016 11:02:38
 */
@SessionScoped
@ManagedBean
public class ContextBean implements Serializable {

	private String content = "/pages/home.xhtml";
	private String currentUserName;
	private Users connectedUser;
	private boolean bolSign = true;

	// String name = auth.getName(); //get logged in username
	// Authentication auth =
	// SecurityContextHolder.getContext().getAuthentication();

	@ManagedProperty(value = ("#{usersServiceImpl}"))
	private UsersService usersService;

	@PostConstruct
	public void init() {
		this.connectedUser = new Users();
		// this.connectedUser=usersService

	}
	
	public void toUsers(){
		this.content="/pages/users.xhtml";
	}	
	public void toHome(){
		System.out.println("#### avant execution toHome");
		this.content="/pages/home.xhtml";
	}
	public void toDevices(){
		this.content="/pages/devices.xhtml";
	}
	public void toMessages(){
		this.content="/pages/messages.xhtml";
	}
	public void toForum(){
		this.content="/pages/forum.xhtml";
	}
	public void toInOut(){
		this.content="/pages/inOut.xhtml";
	}

	public void changeBolSign() {
		this.bolSign = !this.bolSign;
	}

	public void test() {
		System.out.println("your validation login is excecuted ...");
		System.out.println("login" + connectedUser.getEmail());
		System.out.println("password" + connectedUser.getPassword());
	}

	// //////////////////// GETTERS AND SETTERS //////////////////

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getCurrentUserName() {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			currentUserName = auth.getName();
		}
		return currentUserName;
	}

	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}

}
