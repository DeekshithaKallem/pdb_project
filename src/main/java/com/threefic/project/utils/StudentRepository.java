package com.threefic.project.utils;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.threefic.project.models.Course;
import com.threefic.project.models.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	List<Student> findByLastname(String lastname);
	
	Student findByStudentId(Integer id);
	
	@Query("SELECT c FROM Course c JOIN c.students sc WHERE sc.studentId = :id")
	Set<Course> findCoursesByStudentId(@Param("id")Integer studentId);
	
	
}
