package beans;

import java.io.IOException;

import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import dao.UsersDao;


@ManagedBean
@RequestScoped
public class LoginController {
	
	@Autowired
	public UsersDao userDao;
	public String login ;
 
    public String doLogin() throws IOException, ServletException {
    	try {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check");
        dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
        FacesContext.getCurrentInstance().responseComplete();
    	
		} catch (Exception e) {
			System.out.println("login or password failed !");
		}
        return null;
    }
    public String doLogout() throws ServletException, IOException {
      /*  System.out.println("In doLogout()");
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/logout");    
        dispatcher.forward((ServletRequest) context.getRequest(),(ServletResponse) context.getResponse());
        FacesContext.getCurrentInstance().responseComplete();
        refreshPage();*/
        return null;}
    
    protected void refreshPage() {
    	FacesContext fc = FacesContext.getCurrentInstance();
    	String refreshpage = fc.getViewRoot().getViewId();
    	ViewHandler ViewH =fc.getApplication().getViewHandler();
    	UIViewRoot UIV = ViewH.createView(fc,refreshpage);
    	UIV.setViewId(refreshpage);
    	fc.setViewRoot(UIV);
    	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public UsersDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UsersDao userDao) {
		this.userDao = userDao;
	}
    
    
}
