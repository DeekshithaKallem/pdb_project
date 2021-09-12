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
import javax.persistence.Transient;

@Entity // This tells Hibernate to make a table out of this class
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer studentId;

	private String firstname;
	private String lastname;
	private String department;
	private String dateOfBirth;
	private String mailId;

	@Transient
	private String coursesEnrolled;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "students_courses",
	joinColumns = {
			@JoinColumn(name = "student_id", referencedColumnName = "studentId",
					nullable = false, updatable = false)},
	inverseJoinColumns = {
			@JoinColumn(name = "course_id", referencedColumnName = "courseId",
					nullable = false, updatable = false)})
	private Set<Course> courses = new HashSet<>();
	
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastName) {
		this.lastname = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCoursesEnrolled() {
		return coursesEnrolled;
	}
	public void setCoursesEnrolled(String coursesEnrolled) {
		this.coursesEnrolled = coursesEnrolled;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}


}
