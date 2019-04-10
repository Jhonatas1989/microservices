package br.com.sctdb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entity implementation class for Entity: Nota
 *
 */
@Entity
@Table(name = "Nota", catalog = "sctdb", uniqueConstraints = { @UniqueConstraint(columnNames = "IDNOTA") })
@NamedQuery(name = "Nota.findAll", query = "select f from Nota f")
public class Nota implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDNOTA", unique = true, nullable = false)
	private int id;

	@Column(name = "PROJETO1")
	private Double projeto1;

	@Column(name = "PROJETO2")
	private Double projeto2;

	@Column(name = "ATIVIDADEPRATICA")
	private Double atividadePratica;

	@OneToOne
	@JoinColumn(name = "IDDISCIPLINA")
	private Disciplina disciplina;

	@ManyToOne
	@JoinColumn(name = "IDALUNO")
	private Aluno aluno;

	/**
	 * 
	 */
	public Nota() {
	}

	/**
	 * @param id
	 * @param projeto1
	 * @param projeto2
	 * @param atividadePratica
	 * @param disciplina
	 * @param aluno
	 */
	public Nota(int id, Double projeto1, Double projeto2, Double atividadePratica, Disciplina disciplina, Aluno aluno) {
		super();
		this.id = id;
		this.projeto1 = projeto1;
		this.projeto2 = projeto2;
		this.atividadePratica = atividadePratica;
		this.disciplina = disciplina;
		this.aluno = aluno;
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
	 * @return the projeto1
	 */
	public Double getProjeto1() {
		return projeto1;
	}

	/**
	 * @param projeto1 the projeto1 to set
	 */
	public void setProjeto1(Double projeto1) {
		this.projeto1 = projeto1;
	}

	/**
	 * @return the projeto2
	 */
	public Double getProjeto2() {
		return projeto2;
	}

	/**
	 * @param projeto2 the projeto2 to set
	 */
	public void setProjeto2(Double projeto2) {
		this.projeto2 = projeto2;
	}

	/**
	 * @return the atividadePratica
	 */
	public Double getAtividadePratica() {
		return atividadePratica;
	}

	/**
	 * @param atividadePratica the atividadePratica to set
	 */
	public void setAtividadePratica(Double atividadePratica) {
		this.atividadePratica = atividadePratica;
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
	 * @return the aluno
	 */
	public Aluno getAluno() {
		return aluno;
	}

	/**
	 * @param aluno the aluno to set
	 */
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return "Nota [id=" + id + ", projeto1=" + projeto1 + ", projeto2=" + projeto2 + ", atividadePratica="
				+ atividadePratica + ", disciplina=" + disciplina + ", aluno=" + aluno + "]";
	}

}
