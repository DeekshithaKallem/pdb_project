package com.threefic.project.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer courseId;
	
	private String courseName;
	private String department;
	

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private Set<Student> students = new HashSet<>();
    
    
    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private Set<Professor> professors = new HashSet<>();
    
    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private Set<Classroom> classrooms = new HashSet<>();
    
	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(Set<Professor> professors) {
		this.professors = professors;
	}

	public Set<Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(Set<Classroom> classrooms) {
		this.classrooms = classrooms;
	}

}
