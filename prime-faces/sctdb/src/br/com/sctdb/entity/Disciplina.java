package br.com.sctdb.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entity implementation class for Entity: Disciplina
 *
 */
@Entity
@Table(name = "DISCIPLINA", catalog = "sctdb", uniqueConstraints = { @UniqueConstraint(columnNames = "IDDISCIPLINA") })
@NamedQuery(name = "Disciplina.findAll", query = "select f from Disciplina f")
public class Disciplina implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDDISCIPLINA", unique = true, nullable = false)
	private int id;

	@Column(name = "NOME", nullable = false, length = 45)
	private String nome;

	@Column(name = "CARGAHORARIA")
	private Double cargaHoraria;

	@ManyToMany(mappedBy = "disciplinas")
	private List<Professor> professores = new ArrayList<Professor>();

	@ManyToMany(mappedBy = "disciplinas")
	private List<Aluno> alunos = new ArrayList<Aluno>();

	@ManyToMany
	@JoinTable(name = "CURSO_DISCIPLINA", catalog = "sctdb", joinColumns = {
			@JoinColumn(name = "IDDISCIPLINA", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "IDCURSO", nullable = false, updatable = false) })
	private List<Curso> cursos = new ArrayList<Curso>();

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cargaHoraria
	 */
	public Double getCargaHoraria() {
		return cargaHoraria;
	}

	/**
	 * @param cargaHoraria the cargaHoraria to set
	 */
	public void setCargaHoraria(Double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	/**
	 * @return the professores
	 */
	public List<Professor> getProfessores() {
		return professores;
	}

	/**
	 * @param professores the professores to set
	 */
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
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
	 * @return the cursos
	 */
	public List<Curso> getCursos() {
		return cursos;
	}

	/**
	 * @param cursos the cursos to set
	 */
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", nome=" + nome + ", cargaHoraria=" + cargaHoraria + ", professores="
				+ professores + ", alunos=" + alunos + ", cursos=" + cursos + "]";
	}

}
