package br.com.sctdb.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;

import br.com.sctdb.dao.GenericDao;
import br.com.sctdb.entity.Aluno;
import br.com.sctdb.entity.Curso;
import br.com.sctdb.entity.Disciplina;
import br.com.sctdb.entity.Escola;
import br.com.sctdb.entity.Professor;
import br.com.sctdb.entity.Usuario;

@ManagedBean
@ViewScoped
public class ProfessorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Professor professor;
	private Usuario user;

	private List<Escola> selectedEscolas;
	private List<Disciplina> selectedDisciplinas;
	private Set<Aluno> alunos;
	private Set<Curso> cursos;

	public ProfessorBean() {
		professor = new Professor();
		user = new Usuario();
		alunos = new HashSet<Aluno>();
		cursos = new HashSet<Curso>();
	}

	public void cadastrar() {
		GenericDao<Professor> pdao = new GenericDao<Professor>(Professor.class);
		cadastrarUsuario();
		this.professor.setUsuario(this.user);
		try {
			for (Escola escola : selectedEscolas) {
				this.professor.getEscolas().add(escola);
			}
			pdao.cadastrar(this.professor);
			LimparProfessor();
			LimparUsuario();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Professor cadastrado com sucesso!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	public String atualizar() {
		GenericDao<Professor> pdao = new GenericDao<Professor>(Professor.class);
		try {
			for (Disciplina disciplina : selectedDisciplinas) {
				this.professor.getDisciplinas().add(disciplina);
			}
			pdao.alterar(this.professor);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Professor atualizado com sucesso!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		return "lista-professor";
	}

	public void excluir(Professor prof) {
		GenericDao<Professor> pdao = new GenericDao<Professor>(Professor.class);
		try {
			pdao.deletar(prof);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Professor excluido com sucesso!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	public void cadastrarUsuario() {
		this.user.setUsuario(this.professor.getNome().trim());
		this.user.setEmail(this.professor.getEmail());
		this.user.setSenha("123");
		this.user.setTipo(2);
	}

	public void LimparProfessor() {
		System.out.println("Limpar Professor");
		this.professor.setNome("");
		this.professor.setCpf("");
		this.professor.setEmail("");
		this.professor.getEscolas().clear();
	}

	public void LimparUsuario() {
		System.out.println("Limpar Usuario");
		this.user.setEmail("");
		this.user.setSenha("");
		this.user.setTipo(null);
	}

	public List<Professor> getListaProfessores() {
		GenericDao<Professor> pdao = new GenericDao<Professor>(Professor.class);
		return pdao.listar();
	}

	public List<Escola> getListaEscola() {
		GenericDao<Escola> edao = new GenericDao<Escola>(Escola.class);
		return edao.listar();
	}

	public List<Disciplina> getListaDisciplina() {
		GenericDao<Disciplina> ddao = new GenericDao<Disciplina>(Disciplina.class);
		return ddao.listar();
	}

	public void listarAlunos(AjaxBehaviorEvent event) {
		for (Disciplina disciplina : this.professor.getDisciplinas()) {
			for (Aluno al : disciplina.getAlunos()) {
				this.alunos.add(al);
			}
		}
	}

	public void listarCursos(AjaxBehaviorEvent event) {
		for (Disciplina disciplina : this.professor.getDisciplinas()) {
			for (Curso curso : disciplina.getCursos()) {
				this.cursos.add(curso);
			}
		}
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public boolean isEditando() {
		Integer idProfessor = this.professor.getId();
		return idProfessor != null;
	}

	public List<Escola> getSelectedEscolas() {
		return selectedEscolas;
	}

	public void setSelectedEscolas(List<Escola> selectedEscolas) {
		this.selectedEscolas = selectedEscolas;
	}

	public List<Disciplina> getSelectedDisciplinas() {
		return selectedDisciplinas;
	}

	public void setSelectedDisciplinas(List<Disciplina> selectedDisciplinas) {
		this.selectedDisciplinas = selectedDisciplinas;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

}
