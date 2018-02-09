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

import ao.sting.aearp.model.Student;
import ao.sting.aearp.service.StudentService;

@RestController
@RequestMapping("/estudante")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Student> getAllstudent(){
		Iterable<Student> students =  studentService.getAllStudents();
		return students;
	}
	
	@PostMapping()
	public Student saveStudent(@RequestBody @Valid Student student) {
		return studentService.saveStudent(student);
	}
	
	@DeleteMapping()
	public Student deleteStudent(@RequestBody Student student) {
		return studentService.deleteStudent(student);
	}

}
