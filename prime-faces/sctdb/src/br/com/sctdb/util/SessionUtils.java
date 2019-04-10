package br.com.sctdb.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.sctdb.entity.Usuario;

/**
 * @author Jhonatas Oliveira
 *
 */
public class SessionUtils {

	/**
	 * @return HttpSession
	 */
	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	/**
	 * @return HttpServletRequest
	 */
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	/**
	 * 
	 */
	public static void invalidateSession() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

	/**
	 * @return
	 */
	public static Usuario getUser() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return (Usuario) session.getAttribute("usuario");
	}

}
