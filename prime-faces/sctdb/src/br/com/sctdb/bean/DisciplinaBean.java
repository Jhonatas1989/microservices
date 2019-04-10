package br.com.sctdb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.bean.ViewScoped;

import br.com.sctdb.dao.GenericDao;
import br.com.sctdb.entity.Aluno;
import br.com.sctdb.entity.Curso;
import br.com.sctdb.entity.Disciplina;
import br.com.sctdb.entity.Professor;

/**
 * @author Jhonatas Oliveira
 *
 */
@ManagedBean
@ViewScoped
public class DisciplinaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Disciplina disciplina;

	private List<Curso> selectedCursos;
	private List<Aluno> alunos;

	public DisciplinaBean() {
		disciplina = new Disciplina();
		alunos = new ArrayList<Aluno>();
	}

	public void cadastrar() {
		GenericDao<Disciplina> ddao = new GenericDao<Disciplina>(Disciplina.class);
		try {
			for (Curso curso : selectedCursos) {
				this.disciplina.getCursos().add(curso);
			}
			ddao.cadastrar(this.disciplina);
			LimparDisciplina();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Disciplina cadastrada com sucesso!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	public String atualizar() {
		GenericDao<Disciplina> ddao = new GenericDao<Disciplina>(Disciplina.class);
		try {
			ddao.alterar(this.disciplina);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Disciplina atualizado com sucesso!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		return "lista-disciplina";
	}

	public void excluir(Disciplina disc) {
		GenericDao<Disciplina> ddao = new GenericDao<Disciplina>(Disciplina.class);
		try {
			ddao.deletar(disc);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Disciplina excluido com sucesso!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	public void LimparDisciplina() {
		this.disciplina.setNome("");
		this.disciplina.setCargaHoraria(null);
		this.disciplina.getCursos().clear();
	}

	public String cursos(Disciplina d) {
		String cursos = "";
		for (Curso curso : d.getCursos()) {
			cursos += curso.getNome() + " ";
		}
		return cursos;
	}

	public String professores(Disciplina d) {
		String professores = "";
		for (Professor professor : d.getProfessores()) {
			professores += professor.getNome() + " ";
		}
		return professores;
	}

	public List<Disciplina> getListaDisciplinas() {
		GenericDao<Disciplina> ddao = new GenericDao<Disciplina>(Disciplina.class);
		return ddao.listar();
	}

	public void listarAlunos(AjaxBehaviorEvent event) {
		this.alunos = this.disciplina.getAlunos();
	}

	public List<Curso> getListaCurso() {
		GenericDao<Curso> cdao = new GenericDao<Curso>(Curso.class);
		return cdao.listar();
	}

	public List<Curso> getSelectedCursos() {
		return selectedCursos;
	}

	public void setSelectedEscolas(List<Curso> selectedCursos) {
		this.selectedCursos = selectedCursos;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void setSelectedCursos(List<Curso> selectedCursos) {
		this.selectedCursos = selectedCursos;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}
