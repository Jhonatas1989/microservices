package br.com.sctdb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.sctdb.dao.GenericDao;
import br.com.sctdb.entity.Aluno;
import br.com.sctdb.entity.Disciplina;
import br.com.sctdb.entity.Nota;
import br.com.sctdb.entity.Professor;
import br.com.sctdb.entity.Usuario;
import br.com.sctdb.util.SessionUtils;

/**
 * @author Jhonatas Oliveira
 *
 */
@ManagedBean
@ViewScoped
public class MinhaPaginaProfessorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Professor professor;
	private GenericDao<Professor> pdao = new GenericDao<Professor>(Professor.class);
	private List<Aluno> alunos;
	private Disciplina disciplina;
	private Nota nota;

	/**
	 * 
	 */
	public MinhaPaginaProfessorBean() {
		professor = pegarProfessor(SessionUtils.getUser());
		alunos = new ArrayList<Aluno>();
		nota = new Nota();
	}

	/**
	 * @param aluno
	 * @return
	 */
	public Double projeto1(Aluno aluno) {
		Double projeto1 = null;
		for (Nota nota : aluno.getNotas()) {
			if (nota.getDisciplina().getId() == this.disciplina.getId()) {

				if (nota.getProjeto1() == null) {
					projeto1 = 0.0;
				} else {
					projeto1 = nota.getProjeto1();
				}
			}
		}
		return projeto1;
	}

	/**
	 * @param aluno
	 * @return
	 */
	public Double projeto2(Aluno aluno) {
		Double projeto2 = null;
		for (Nota nota : aluno.getNotas()) {
			if (nota.getDisciplina().getId() == this.disciplina.getId()) {

				if (nota.getProjeto2() == null) {
					projeto2 = 0.0;
				} else {
					projeto2 = nota.getProjeto2();
				}
			}
		}
		return projeto2;
	}

	/**
	 * @param aluno
	 * @return
	 */
	public Double atividadePratica(Aluno aluno) {
		Double atividadePratica = null;
		for (Nota nota : aluno.getNotas()) {
			if (nota.getDisciplina().getId() == this.disciplina.getId()) {

				if (nota.getAtividadePratica() == null) {
					atividadePratica = 0.0;
				} else {
					atividadePratica = nota.getAtividadePratica();
				}
			}
		}
		return atividadePratica;
	}

	/**
	 * @param aluno
	 * @return
	 */
	public String aprovacao(Aluno aluno) {
		String aprovado;
		Double nota1 = projeto1(aluno) * 0.3;
		Double nota2 = projeto2(aluno) * 0.3;
		Double nota3 = atividadePratica(aluno) * 0.4;
		Double total = nota1 + nota2 + nota3;
		if (total >= 7.0) {
			aprovado = "Aprovado";
		} else {
			aprovado = "Reprovado";
		}
		return aprovado;
	}

	/**
	 * @param aluno
	 * @return
	 */
	public Integer idNotaAluno(Aluno aluno) {
		Integer idNota = null;
		for (Nota nota : aluno.getNotas()) {
			if (nota.getDisciplina().getId() == this.disciplina.getId()) {
				idNota = nota.getId();
			}
		}
		return idNota;
	}

	/**
	 * @return
	 */
	public String cadastraNota() {
		GenericDao<Nota> ndao = new GenericDao<Nota>(Nota.class);
		try {
			ndao.alterar(this.nota);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Nota cadastrado com sucesso!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		return "professor";
	}

	/**
	 * @param user
	 * @return
	 */
	public Professor pegarProfessor(Usuario user) {
		Professor profe = null;
		for (Professor professor : pdao.listar()) {
			if (professor.getEmail().equals(user.getEmail())) {
				profe = professor;
			}
		}
		return profe;
	}

	/**
	 * @return the professor
	 */
	public Professor getProfessor() {
		return professor;
	}

	/**
	 * @param professor the professor to set
	 */
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	/**
	 * @return the pdao
	 */
	public GenericDao<Professor> getPdao() {
		return pdao;
	}

	/**
	 * @param pdao the pdao to set
	 */
	public void setPdao(GenericDao<Professor> pdao) {
		this.pdao = pdao;
	}

	/**
	 * @return the alunos
	 */
	public List<Aluno> getAlunos() {
		return alunos;
	}

	/**
	 * @param alunos the alunos to set
	 */
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	/**
	 * @return the disciplina
	 */
	public Disciplina getDisciplina() {
		return disciplina;
	}

	/**
	 * @param disciplina the disciplina to set
	 */
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	/**
	 * @return the nota
	 */
	public Nota getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(Nota nota) {
		this.nota = nota;
	}

}
