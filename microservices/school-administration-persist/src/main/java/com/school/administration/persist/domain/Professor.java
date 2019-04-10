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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entity implementation class for Entity: Professor
 * 
 * @author Jhonatas Oliveira
 *
 */
@Entity
@Table(name = "PROFESSOR", catalog = "sctdb", uniqueConstraints = { @UniqueConstraint(columnNames = "IDPROFESSOR") })
public class Professor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDPROFESSOR", unique = true, nullable = false)
	private int id;

	@Column(name = "NAME", nullable = false, length = 45)
	private String name;

	@Column(name = "CPF", nullable = false, length = 45, unique = true)
	private String cpf;

	@Column(name = "EMAIL", nullable = false, length = 45, unique = true)
	private String email;

	@ManyToMany
	@JoinTable(name = "PROFESSOR_SCHOOL", catalog = "sctdb", joinColumns = {
			@JoinColumn(name = "IDPROFESSOR", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "IDSCHOOL", nullable = false, updatable = false) })
	private List<School> schools = new ArrayList<School>();

	@ManyToMany
	@JoinTable(name = "PROFESSOR_SUBJECT", catalog = "sctdb", joinColumns = {
			@JoinColumn(name = "IDPROFESSOR", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "IDSUBJECT", nullable = false, updatable = false) })
	private List<Subject> subjects = new ArrayList<Subject>();

	@OneToOne(cascade = CascadeType.ALL)
	private User users;

	/**
	 * 
	 */
	public Professor() {
	}

	/**
	 * @param id
	 * @param name
	 * @param cpf
	 * @param email
	 * @param schools
	 * @param subjects
	 * @param users
	 */
	public Professor(int id, String name, String cpf, String email, List<School> schools, List<Subject> subjects,
			User users) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.schools = schools;
		this.subjects = subjects;
		this.users = users;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the schools
	 */
	public List<School> getSchools() {
		return schools;
	}

	/**
	 * @param schools the schools to set
	 */
	public void setSchools(List<School> schools) {
		this.schools = schools;
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

	/**
	 * @return the users
	 */
	public User getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(User users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", name=" + name + ", cpf=" + cpf + ", email=" + email + ", schools=" + schools
				+ ", Subjects=" + subjects + ", users=" + users + "]";
	}

}
