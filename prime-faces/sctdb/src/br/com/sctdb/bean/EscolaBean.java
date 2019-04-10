package br.com.sctdb.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import br.com.sctdb.dao.GenericDao;
import br.com.sctdb.entity.Escola;

@ManagedBean
@ViewScoped
public class EscolaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Escola escola;

	public EscolaBean() {
		escola = new Escola();
	}

	public void cadastrar() {
		GenericDao<Escola> edao = new GenericDao<Escola>(Escola.class);
		try {
			edao.cadastrar(this.escola);
			LimparEscola();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Escola cadastrada com sucesso!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	public String atualizar() {
		GenericDao<Escola> edao = new GenericDao<Escola>(Escola.class);
		try {
			edao.alterar(this.escola);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Escola atualizada com sucesso!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		return "lista-escola";
	}

	public void excluir(Escola esc) {
		try {
			GenericDao<Escola> edao = new GenericDao<Escola>(Escola.class);
			edao.deletar(esc);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Escola excluida com sucesso!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	public void LimparEscola() {
		this.escola.setNome("");
		this.escola.setEndereco("");
		this.escola.setTelefone("");
	}

	public List<Escola> getListaEscolas() {
		GenericDao<Escola> edao = new GenericDao<Escola>(Escola.class);
		return edao.listar();
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {

		this.escola = escola;
	}

	public boolean isEditando() {
		Integer idEscola = this.escola.getId();
		return idEscola != null;
	}

}
