package br.com.sctdb.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entity implementation class for Entity: Escola
 *
 */
@Entity
@Table(name = "ESCOLA", catalog = "sctdb", uniqueConstraints = { @UniqueConstraint(columnNames = "IDESCOLA") })
@NamedQuery(name = "Escola.findAll", query = "select f from Escola f")
public class Escola implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDESCOLA", unique = true, nullable = false)
	private int id;

	@Column(name = "NOME", nullable = false, length = 45, unique = true)
	private String nome;

	@Column(name = "ENDERECO", nullable = false, length = 45)
	private String endereco;

	@Column(name = "TELEFONE", nullable = false, length = 45)
	private String telefone;

	@ManyToMany(mappedBy = "escolas")
	private List<Curso> cursos = new ArrayList<Curso>();

	@ManyToMany(mappedBy = "escolas")
	private List<Professor> professores = new ArrayList<Professor>();

	@OneToMany
	private List<Aluno> alunos = new ArrayList<Aluno>();

	/**
	 * 
	 */
	public Escola() {
	}

	/**
	 * @param id
	 * @param nome
	 * @param endereco
	 * @param telefone
	 * @param cursos
	 * @param professores
	 * @param alunos
	 */
	public Escola(int id, String nome, String endereco, String telefone, List<Curso> cursos,
			List<Professor> professores, List<Aluno> alunos) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cursos = cursos;
		this.professores = professores;
		this.alunos = alunos;
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
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Escola other = (Escola) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Escola [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", cursos="
				+ cursos + ", professores=" + professores + ", alunos=" + alunos + "]";
	}

}
