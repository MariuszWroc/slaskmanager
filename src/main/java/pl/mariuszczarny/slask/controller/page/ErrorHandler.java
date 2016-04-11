package pl.mariuszczarny.slask.controller.page;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ErrorHandler {
	public String getStatusCode(){
		return String.valueOf((Integer)FacesContext.getCurrentInstance().getExternalContext().
				getRequestMap().get("javax.servlet.error.status_code"));
	}

	public String getMessage(){
		return  (String)FacesContext.getCurrentInstance().getExternalContext().
			getRequestMap().get("javax.servlet.error.message");
	}

	public String getExceptionType(){
		return FacesContext.getCurrentInstance().getExternalContext().
			getRequestMap().get("javax.servlet.error.exception_type").toString();
	}

	public String getException(){
		return  (String)((Exception)FacesContext.getCurrentInstance().getExternalContext().
			getRequestMap().get("javax.servlet.error.exception")).toString();
	}

	public String getRequestURI(){
		return (String)FacesContext.getCurrentInstance().getExternalContext().
			getRequestMap().get("javax.servlet.error.request_uri");
	}

	public String getServletName(){
		return (String)FacesContext.getCurrentInstance().getExternalContext().
			getRequestMap().get("javax.servlet.error.servlet_name");
	}
}
