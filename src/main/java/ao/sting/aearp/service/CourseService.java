package ao.sting.aearp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ao.sting.aearp.model.Course;
import ao.sting.aearp.repository.Courses;

@Service
public class CourseService {
	
	@Autowired
	private Courses courses;
	
	public Iterable<Course> getAllCourses(){
		return courses.findAll();
	}
	
	public Course saveCourse(Course course){
		return courses.save(course);
	}
	
	public Course deleteCourse(Course course) {
		courses.delete(course);
		return course;
	}

}
