package br.com.sctdb.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.sctdb.dao.GenericDao;
import br.com.sctdb.entity.Usuario;
import br.com.sctdb.util.SessionUtils;

/**
 * @author Jhonatas Oliveira
 *
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	private boolean loggedIn;

	/**
	 * 
	 */
	public LoginBean() {
		usuario = new Usuario();
	}

	/**
	 * @return
	 */
	public String logar() {
		GenericDao<Usuario> udao = new GenericDao<Usuario>(Usuario.class);
		String redirect = "";
		try {
			Boolean isUsuarioValido = false;
			for (Usuario user : udao.listar()) {
				if (this.usuario.getUsuario().equals(user.getUsuario())
						&& this.usuario.getSenha().equals(user.getSenha())) {
					isUsuarioValido = true;
					loggedIn = true;
					this.usuario = user;

					SessionUtils.getSession().setAttribute("usuario", this.usuario);
				}
			}
			if (isUsuarioValido) {
				switch (this.usuario.getTipo()) {
				case 1:
					redirect = "/paginas/minhapagina/administrador?faces-redirect=true";
					break;

				case 2:
					redirect = "/paginas/minhapagina/professor?faces-redirect=true";
					break;

				case 3:
					redirect = "/paginas/minhapagina/aluno?faces-redirect=true";
					break;
				}
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario ou Senha Invalido!", null));
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		return redirect;
	}

	/**
	 * @return
	 */
	public String deslogar() {
		SessionUtils.invalidateSession();
		return "/index?faces-redirect=true";
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the loggedIn
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}

	/**
	 * @param loggedIn the loggedIn to set
	 */
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
