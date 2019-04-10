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
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Table(name = "Nota", catalog = "sctdb", uniqueConstraints = { @UniqueConstraint(columnNames = "IDNOTA") })
@NamedQuery(name = "Nota.findAll", query = "select f from Nota f")
public class Nota implements Serializable {

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getProjeto1() {
		return projeto1;
	}

	public void setProjeto1(Double projeto1) {
		this.projeto1 = projeto1;
	}

	public Double getProjeto2() {
		return projeto2;
	}

	public void setProjeto2(Double projeto2) {
		this.projeto2 = projeto2;
	}

	public Double getAtividadePratica() {
		return atividadePratica;
	}

	public void setAtividadePratica(Double atividadePratica) {
		this.atividadePratica = atividadePratica;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
