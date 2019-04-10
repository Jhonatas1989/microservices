package com.school.administration.persist.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entity implementation class for Entity: School
 *
 * @author Jhonatas Oliveira
 * 
 */
@Entity
@Table(name = "SCHOOL", catalog = "sctdb", uniqueConstraints = { @UniqueConstraint(columnNames = "IDSCHOOL") })
//@NamedQuery(name = "School.findAll", query = "select f from School f")
public class School implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDSCHOOL", unique = true, nullable = false)
	private int id;

	@Column(name = "NAME", nullable = false, length = 45, unique = true)
	private String name;

	@Column(name = "ADDRESS", nullable = false, length = 45)
	private String address;

	@Column(name = "PHONE", nullable = false, length = 45)
	private String phone;

	@ManyToMany(mappedBy = "schools")
	private List<Course> courses = new ArrayList<Course>();

	@ManyToMany(mappedBy = "schools")
	private List<Professor> professors = new ArrayList<Professor>();

	@OneToMany
	private List<Student> students = new ArrayList<Student>();

	/**
	 * 
	 */
	public School() {
	}

	/**
	 * @param id
	 * @param name
	 * @param address
	 * @param phone
	 * @param courses
	 * @param professors
	 * @param students
	 */
	public School(int id, String name, String address, String phone, List<Course> courses, List<Professor> professors,
			List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.courses = courses;
		this.professors = professors;
		this.students = students;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", courses="
				+ courses + ", professors=" + professors + ", students=" + students + "]";
	}

}
