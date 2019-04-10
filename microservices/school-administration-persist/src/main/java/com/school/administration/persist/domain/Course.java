package com.school.administration.persist.domain;

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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entity implementation class for Entity: Course
 * @author Jhonatas Oliveira
 */
/**
 * @author user
 *
 */
@Entity
@Table(name = "COURSE", catalog = "sctdb", uniqueConstraints = { @UniqueConstraint(columnNames = "IDCOURSE") })
//@NamedQuery(name = "Course.findAll", query = "select f from Curso f")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCOURSE", unique = true, nullable = false)
	private int id;

	@Column(name = "NAME", nullable = false, length = 45, unique = true)
	private String name;

	@ManyToMany
	@JoinTable(name = "COURSE_SCHOOL", catalog = "sctdb", joinColumns = {
			@JoinColumn(name = "IDCOURSE", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "IDSCHOOL", nullable = false, updatable = false) })
	private List<School> schools = new ArrayList<School>();

	@ManyToMany(mappedBy = "courses")
	private List<Subject> subjects = new ArrayList<Subject>();

	/**
	 * 
	 */
	public Course() {
	}

	/**
	 * @param id
	 * @param name
	 * @param schools
	 * @param subjects
	 */
	public Course(int id, String name, List<School> schools, List<Subject> subjects) {
		super();
		this.id = id;
		this.name = name;
		this.schools = schools;
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

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", schools=" + schools + ", subjects=" + subjects + "]";
	}

}
