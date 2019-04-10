package br.com.sctdb.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import br.com.sctdb.dao.GenericDao;
import br.com.sctdb.entity.Aluno;
import br.com.sctdb.entity.Curso;
import br.com.sctdb.entity.Disciplina;
import br.com.sctdb.entity.Escola;
import br.com.sctdb.entity.Nota;
import br.com.sctdb.entity.Usuario;

@ManagedBean
@ViewScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Aluno aluno;
	private Usuario user;

	public AlunoBean() {
		aluno = new Aluno();
		user = new Usuario();
	}

	public void cadastrar() {
		GenericDao<Aluno> adao = new GenericDao<Aluno>(Aluno.class);
		try {
			cadastrarUsuario();
			this.aluno.setUsuario(this.user);
			adao.cadastrar(this.aluno);
			LimparAluno();
			LimparUsuario();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Aluno cadastrado com sucesso!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	public String atualizar() {
		GenericDao<Aluno> adao = new GenericDao<Aluno>(Aluno.class);
		try {
			if (this.aluno.getCurso() != null && this.aluno.getDisciplinas().isEmpty()) {
				cadastrarDisciplinas(this.aluno.getCurso());
			}
			adao.alterar(this.aluno);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Aluno atualizado com sucesso!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		return "lista-aluno";
	}

	public void excluir(Aluno alu) {
		GenericDao<Aluno> adao = new GenericDao<Aluno>(Aluno.class);
		try {
			adao.deletar(alu);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Aluno excluido com sucesso!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	public void cadastrarDisciplinas(Curso curso) {
		for (Disciplina disciplina : curso.getDisciplinas()) {
			GenericDao<Nota> ndao = new GenericDao<Nota>(Nota.class);
			Nota nota = new Nota();
			nota.setAluno(this.aluno);
			nota.setDisciplina(disciplina);
			ndao.cadastrar(nota);
			this.aluno.getDisciplinas().add(disciplina);
		}
	}

	public void cadastrarUsuario() {
		this.user.setUsuario(this.aluno.getNome().trim());
		this.user.setEmail(this.aluno.getEmail());
		this.user.setSenha("123");
		this.user.setTipo(3);
	}

	public void LimparAluno() {
		this.aluno.setNome("");
		this.aluno.setEmail("");
		this.aluno.setEscola(null);
		this.aluno.setCurso(null);
		this.aluno.setUsuario(null);
		this.aluno.getNotas().clear();
	}

	public void LimparUsuario() {
		this.user.setEmail("");
		this.user.setSenha("");
		this.user.setTipo(null);
	}

	public List<Curso> getListaCurso() {
		GenericDao<Curso> cdao = new GenericDao<Curso>(Curso.class);
		return cdao.listar();
	}

	public List<Escola> getListaEscola() {
		GenericDao<Escola> edao = new GenericDao<Escola>(Escola.class);
		return edao.listar();
	}

	public List<Aluno> getListaAluno() {
		GenericDao<Aluno> adao = new GenericDao<Aluno>(Aluno.class);
		return adao.listar();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

}
