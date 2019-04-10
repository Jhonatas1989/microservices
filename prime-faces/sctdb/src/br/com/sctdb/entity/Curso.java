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
 * Entity implementation class for Entity: Curso
 *
 */
@Entity
@Table(name = "CURSO", catalog = "sctdb", uniqueConstraints = { @UniqueConstraint(columnNames = "IDCURSO") })
@NamedQuery(name = "Curso.findAll", query = "select f from Curso f")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCURSO", unique = true, nullable = false)
	private int id;

	@Column(name = "NOME", nullable = false, length = 45, unique = true)
	private String nome;

	@ManyToMany
	@JoinTable(name = "CURSO_ESCOLA", catalog = "sctdb", joinColumns = {
			@JoinColumn(name = "IDCURSO", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "IDESCOLA", nullable = false, updatable = false) })
	private List<Escola> escolas = new ArrayList<Escola>();

	@ManyToMany(mappedBy = "cursos")
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

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

	public List<Escola> getEscolas() {
		return escolas;
	}

	public void setEscolas(List<Escola> escolas) {
		this.escolas = escolas;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
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
		Curso other = (Curso) obj;
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
