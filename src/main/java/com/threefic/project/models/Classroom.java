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
public class Classroom {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer classroomId;
	
	private String address;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "classrooms_courses",
	joinColumns = {
			@JoinColumn(name = "classroom_id", referencedColumnName = "classroomId",
					nullable = false, updatable = false)},
	inverseJoinColumns = {
			@JoinColumn(name = "course_id", referencedColumnName = "courseId",
					nullable = false, updatable = false)})
	private Set<Course> courses = new HashSet<>();
	
	public Integer getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(Integer classroomId) {
		this.classroomId = classroomId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
