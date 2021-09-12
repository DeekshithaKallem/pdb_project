package com.threefic.project.utils;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.threefic.project.models.Classroom;
import com.threefic.project.models.Course;
import com.threefic.project.models.Professor;

public interface CourseRepository extends CrudRepository<Course, Integer> {

	  List<Course> findByCourseNameContaining(String courseName);
	  
	  Course findByCourseId(Integer id);
	  
	  @Query("SELECT p FROM Professor p JOIN p.courses pc WHERE pc.courseId = :id")
	  Set<Professor> findProfessorByCourseId(@Param("id")Integer courseId);
	  
	  @Query("SELECT cs FROM Classroom cs JOIN cs.courses csc WHERE csc.courseId = :id")
	  Set<Classroom> findClassroomByCourseId(@Param("id")Integer courseId);
}
