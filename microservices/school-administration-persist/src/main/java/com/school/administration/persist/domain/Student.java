package com.school.administration.persist.domain;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entity implementation class for Entity: Student
 * 
 * @author Jhonatas Oliveira
 *
 */
@Entity
@Table(name = "STUDENT", catalog = "sctdb", uniqueConstraints = { @UniqueConstraint(columnNames = "IDSTUDENT") })
//@NamedQuery(name = "Aluno.findAll", query = "select f from Aluno f")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDSTUDENT", unique = true, nullable = false)
	private int id;

	@Column(name = "NAME", nullable = false, length = 45)
	private String nome;

	@Column(name = "CPF", nullable = false, length = 45, unique = true)
	private String cpf;

	@Column(name = "EMAIL", nullable = false, length = 45, unique = true)
	private String email;

	@ManyToOne
	@JoinColumn(name = "IDSCHOOL")
	private School school;

	@OneToOne
	private Course course;

	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	@OneToMany(mappedBy = "schools")
	private List<Grade> grades = new ArrayList<Grade>();

	@ManyToMany
	@JoinTable(name = "STUDENT_GRADE", catalog = "sctdb", joinColumns = {
			@JoinColumn(name = "IDSTUDENT", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "IDGRADE", nullable = false, updatable = false) })
	private List<Subject> subjects = new ArrayList<Subject>();

	/**
	 * 
	 */
	public Student() {
	}

	/**
	 * @param id
	 * @param nome
	 * @param cpf
	 * @param email
	 * @param school
	 * @param course
	 * @param usuario
	 * @param grades
	 * @param subjects
	 */
	public Student(int id, String nome, String cpf, String email, School school, Course course, User user,
			List<Grade> grades, List<Subject> subjects) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.school = school;
		this.course = course;
		this.user = user;
		this.grades = grades;
		this.subjects = subjects;
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
	 * @return the school
	 */
	public School getSchool() {
		return school;
	}

	/**
	 * @param school the school to set
	 */
	public void setSchool(School school) {
		this.school = school;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param usuario the user to set
	 */
	public void setUsuario(User user) {
		this.user = user;
	}

	/**
	 * @return the grades
	 */
	public List<Grade> getGrades() {
		return grades;
	}

	/**
	 * @param grades the grades to set
	 */
	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	/**
	 * @return the subjects
	 */
	public List<Subject> getSubjects() {
		return subjects;
	}

	/**
	 * @param subjects the subjects to set
	 */
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", school=" + school
				+ ", course=" + course + ", user=" + user + ", grades=" + grades + ", subjects=" + subjects + "]";
	}

}
