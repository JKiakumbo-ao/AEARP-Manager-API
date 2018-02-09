package ao.sting.aearp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ao.sting.aearp.model.Course;
import ao.sting.aearp.service.CourseService;

@RestController
@RequestMapping("/curso")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@PostMapping()
	public Course saveCourse(@RequestBody @Valid Course course) {
		return courseService.saveCourse(course);
	}
	
	@DeleteMapping()
	public Course deleteCourse(@RequestBody Course course) {
		return courseService.deleteCourse(course);
	}

}
