package br.com.sctdb.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.ViewScoped;

import br.com.sctdb.dao.GenericDao;
import br.com.sctdb.entity.Usuario;

/**
 * @author Jhonatas Oliveira
 *
 */
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private String tipoUsuario;

	/**
	 * 
	 */
	public UsuarioBean() {
		usuario = new Usuario();
	}

	/**
	 * 
	 */
	public void cadastrar() {
		GenericDao<Usuario> udao = new GenericDao<Usuario>(Usuario.class);
		try {
			// Usuario Administrador
			this.usuario.setTipo(1);
			udao.cadastrar(this.usuario);
			LimparUsuario();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Usuario Administrador cadastrado com sucesso!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	/**
	 * @return
	 */
	public String atualizar() {
		GenericDao<Usuario> udao = new GenericDao<Usuario>(Usuario.class);
		try {
			udao.alterar(this.usuario);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Usuario Administrador atualizado com sucesso!", null));
		} catch (

		Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		return "lista-usuario";
	}

	/**
	 * @param user
	 */
	public void excluir(Usuario user) {
		GenericDao<Usuario> udao = new GenericDao<Usuario>(Usuario.class);
		try {
			udao.deletar(user);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario excluido com sucesso!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	/**
	 * 
	 */
	public void LimparUsuario() {
		this.usuario.setEmail("");
		this.usuario.setTipo(null);
		this.usuario.setUsuario("");
		this.usuario.setSenha("");
	}

	/**
	 * @return
	 */
	public List<Usuario> getListaUsuarios() {
		GenericDao<Usuario> udao = new GenericDao<Usuario>(Usuario.class);
		return udao.listar();
	}

	/**
	 * @return
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 * @return
	 */
	public String tipoUsuario(Usuario usuario) {
		int tipo = usuario.getTipo().intValue();
		String strTipo = "";
		if (tipo == 1) {
			strTipo = "Administrador";
		} else if (tipo == 2) {
			strTipo = "Professor";
		} else if (tipo == 3) {
			strTipo = "Aluno";
		}
		return strTipo;
	}

	/**
	 * @return
	 */
	public String getTipoUsuario() {
		if (isEditando()) {
			tipoUsuario = tipoUsuario(this.usuario);
		}
		return tipoUsuario;
	}

	/**
	 * @param tipoUsuario
	 */
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	/**
	 * @param usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return
	 */
	public boolean isEditando() {
		Integer idUsuario = this.usuario.getId();
		return idUsuario != null;
	}

}
