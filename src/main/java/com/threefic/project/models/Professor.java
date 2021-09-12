package com.threefic.project.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer professorId;
	
	private String firstname;
	private String lastname;
	private String department;
	private String dateOfBirth;
	private String experience;
	private String mailId;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "professors_courses",
	joinColumns = {
			@JoinColumn(name = "professor_id", referencedColumnName = "professorId",
					nullable = false, updatable = false)},
	inverseJoinColumns = {
			@JoinColumn(name = "course_id", referencedColumnName = "courseId",
					nullable = false, updatable = false)})
	private Set<Course> courses = new HashSet<>();
	
	public Integer getProfessorId() {
		return professorId;
	}
	public void setProfessorId(Integer professorId) {
		this.professorId = professorId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
