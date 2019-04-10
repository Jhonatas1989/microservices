package br.com.sctdb.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entity implementation class for Entity: Professor
 *
 */
@Entity
@Table(name = "PROFESSOR", catalog = "sctdb", uniqueConstraints = { @UniqueConstraint(columnNames = "IDPROFESSOR") })
@NamedQuery(name = "Professor.findAll", query = "select f from Professor f")
public class Professor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDPROFESSOR", unique = true, nullable = false)
	private int id;

	@Column(name = "NOME", nullable = false, length = 45)
	private String nome;

	@Column(name = "CPF", nullable = false, length = 45, unique = true)
	private String cpf;

	@Column(name = "EMAIL", nullable = false, length = 45, unique = true)
	private String email;

	@ManyToMany
	@JoinTable(name = "PROFESSOR_ESCOLA", catalog = "sctdb", joinColumns = {
			@JoinColumn(name = "IDPROFESSOR", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "IDESCOLA", nullable = false, updatable = false) })
	private List<Escola> escolas = new ArrayList<Escola>();

	@ManyToMany
	@JoinTable(name = "PROFESSOR_DISCIPLINA", catalog = "sctdb", joinColumns = {
			@JoinColumn(name = "IDPROFESSOR", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "IDDISCIPLINA", nullable = false, updatable = false) })
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		Professor other = (Professor) obj;
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
