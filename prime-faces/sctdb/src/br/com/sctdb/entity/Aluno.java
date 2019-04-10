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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entity implementation class for Entity: Aluno
 *
 */
@Entity
@Table(name = "ALUNO", catalog = "sctdb", uniqueConstraints = { @UniqueConstraint(columnNames = "IDALUNO") })
@NamedQuery(name = "Aluno.findAll", query = "select f from Aluno f")
public class Aluno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDALUNO", unique = true, nullable = false)
	private int id;

	@Column(name = "NOME", nullable = false, length = 45)
	private String nome;

	@Column(name = "CPF", nullable = false, length = 45, unique = true)
	private String cpf;

	@Column(name = "EMAIL", nullable = false, length = 45, unique = true)
	private String email;

	@ManyToOne
	@JoinColumn(name = "IDESCOLA")
	private Escola escola;

	@OneToOne
	private Curso curso;

	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;

	@OneToMany(mappedBy = "aluno")
	private List<Nota> notas = new ArrayList<Nota>();

	@ManyToMany
	@JoinTable(name = "ALUNO_DISCIPLINA", catalog = "sctdb", joinColumns = {
			@JoinColumn(name = "IDALUNO", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "IDDISCIPLINA", nullable = false, updatable = false) })
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	/**
	 * 
	 */
	public Aluno() {
	}

	/**
	 * @param id
	 * @param nome
	 * @param cpf
	 * @param email
	 * @param escola
	 * @param curso
	 * @param usuario
	 * @param notas
	 * @param disciplinas
	 */
	public Aluno(int id, String nome, String cpf, String email, Escola escola, Curso curso, Usuario usuario,
			List<Nota> notas, List<Disciplina> disciplinas) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.escola = escola;
		this.curso = curso;
		this.usuario = usuario;
		this.notas = notas;
		this.disciplinas = disciplinas;
	}

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
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the escola
	 */
	public Escola getEscola() {
		return escola;
	}

	/**
	 * @param escola the escola to set
	 */
	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	/**
	 * @return the curso
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the notas
	 */
	public List<Nota> getNotas() {
		return notas;
	}

	/**
	 * @param notas the notas to set
	 */
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	/**
	 * @return the disciplinas
	 */
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	/**
	 * @param disciplinas the disciplinas to set
	 */
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
		Aluno other = (Aluno) obj;
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
		return "Aluno [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", escola=" + escola
				+ ", curso=" + curso + ", usuario=" + usuario + ", notas=" + notas + ", disciplinas=" + disciplinas
				+ "]";
	}

}
