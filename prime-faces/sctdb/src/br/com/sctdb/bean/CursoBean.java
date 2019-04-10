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

@ManagedBean
@ViewScoped
public class CursoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Curso curso;
	private Set<Aluno> alunos;
	private List<Escola> selectedEscolas;

	public CursoBean() {
		curso = new Curso();
		alunos = new HashSet<Aluno>();
	}

	public void cadastrar() {
		GenericDao<Curso> cdao = new GenericDao<Curso>(Curso.class);
		try {
			for (Escola escola : selectedEscolas) {
				this.curso.getEscolas().add(escola);
			}
			cdao.cadastrar(this.curso);
			LimparCurso();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso cadastrado com sucesso!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	public String atualizar() {
		GenericDao<Curso> cdao = new GenericDao<Curso>(Curso.class);
		try {
			cdao.alterar(this.curso);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso atualizado com sucesso!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		return "lista-curso";
	}

	public void excluir(Curso cur) {
		GenericDao<Curso> cdao = new GenericDao<Curso>(Curso.class);
		try {
			cdao.deletar(cur);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso excluido com sucesso!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	public void LimparCurso() {
		this.curso.setNome("");
		this.curso.getEscolas().clear();
	}

	public List<Escola> getListaEscola() {
		GenericDao<Escola> edao = new GenericDao<Escola>(Escola.class);
		return edao.listar();
	}

	public List<Curso> getListaCursos() {
		GenericDao<Curso> cdao = new GenericDao<Curso>(Curso.class);
		return cdao.listar();
	}

	public String disciplinas(Curso c) {
		String disciplinas = "";
		for (Disciplina disciplina : c.getDisciplinas()) {
			disciplinas += disciplina.getNome() + " ";
		}
		return disciplinas;
	}

	public void listarAlunos(AjaxBehaviorEvent event) {
		for (Disciplina disciplina : this.curso.getDisciplinas()) {
			for (Aluno al : disciplina.getAlunos()) {
				this.alunos.add(al);
			}
		}
	}

	public List<Escola> getSelectedEscolas() {
		return selectedEscolas;
	}

	public void setSelectedEscolas(List<Escola> selectedEscolas) {
		this.selectedEscolas = selectedEscolas;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

}
