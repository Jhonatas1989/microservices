package com.school.administration.persist.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entity implementation class for Entity: Grade
 *
 */
@Entity
@Table(name = "GRADE", catalog = "sctdb", uniqueConstraints = { @UniqueConstraint(columnNames = "IDGRADE") })
//@NamedQuery(name = "Nota.findAll", query = "select f from Nota f")
public class Grade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDGRADE", unique = true, nullable = false)
	private int id;

	@Column(name = "PROJECT1")
	private Double project1;

	@Column(name = "PROJECT2")
	private Double project2;

	@Column(name = "ACTIVITY")
	private Double activity;

	@OneToOne
	@JoinColumn(name = "IDSUBJECT")
	private Subject subject;

	@ManyToOne
	@JoinColumn(name = "IDSTUDENT")
	private Student student;

	/**
	 * 
	 */
	public Grade() {
	}

	/**
	 * @param id
	 * @param project1
	 * @param project2
	 * @param activity
	 * @param subject
	 * @param student
	 */
	public Grade(int id, Double project1, Double project2, Double activity, Subject subject, Student student) {
		super();
		this.id = id;
		this.project1 = project1;
		this.project2 = project2;
		this.activity = activity;
		this.subject = subject;
		this.student = student;
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
	 * @return the project1
	 */
	public Double getProject1() {
		return project1;
	}

	/**
	 * @param project1 the project1 to set
	 */
	public void setProject1(Double project1) {
		this.project1 = project1;
	}

	/**
	 * @return the project2
	 */
	public Double getProject2() {
		return project2;
	}

	/**
	 * @param project2 the project2 to set
	 */
	public void setProject2(Double project2) {
		this.project2 = project2;
	}

	/**
	 * @return the activity
	 */
	public Double getActivity() {
		return activity;
	}

	/**
	 * @param activity the activity to set
	 */
	public void setActivity(Double activity) {
		this.activity = activity;
	}

	/**
	 * @return the subject
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Grade [id=" + id + ", project1=" + project1 + ", project2=" + project2 + ", activity=" + activity
				+ ", subject=" + subject + ", student=" + student + "]";
	}

}
