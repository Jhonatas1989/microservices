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
 * Entity implementation class for Entity: Subject
 *
 * @author Jhonatas Oliveira
 *
 */
@Entity
@Table(name = "SUBJECT", catalog = "sctdb", uniqueConstraints = { @UniqueConstraint(columnNames = "IDSUBJECT") })
//@NamedQuery(name = "Disciplina.findAll", query = "select f from Disciplina f")
public class Subject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDSUBJECT", unique = true, nullable = false)
	private int id;

	@Column(name = "NAME", nullable = false, length = 45)
	private String name;

	@Column(name = "HOUR")
	private Double hour;

	@ManyToMany(mappedBy = "subjects")
	private List<Professor> professors = new ArrayList<Professor>();

	@ManyToMany(mappedBy = "subjects")
	private List<Student> students = new ArrayList<Student>();

	@ManyToMany
	@JoinTable(name = "COURSE_SUBJECT", catalog = "sctdb", joinColumns = {
			@JoinColumn(name = "IDSUBJECT", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "IDCOURSE", nullable = false, updatable = false) })
	private List<Course> courses = new ArrayList<Course>();

	/**
	 * 
	 */
	public Subject() {
	}

	/**
	 * @param id
	 * @param name
	 * @param hour
	 * @param professors
	 * @param students
	 * @param courses
	 */
	public Subject(int id, String name, Double hour, List<Professor> professors, List<Student> students,
			List<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.hour = hour;
		this.professors = professors;
		this.students = students;
		this.courses = courses;
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
	 * @return the hour
	 */
	public Double getHour() {
		return hour;
	}

	/**
	 * @param hour the hour to set
	 */
	public void setHour(Double hour) {
		this.hour = hour;
	}

	/**
	 * @return the professors
	 */
	public List<Professor> getProfessors() {
		return professors;
	}

	/**
	 * @param professors the professors to set
	 */
	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	/**
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	/**
	 * @return the courses
	 */
	public List<Course> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", hour=" + hour + ", professors=" + professors + ", students="
				+ students + ", courses=" + courses + "]";
	}

}
