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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
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

}
