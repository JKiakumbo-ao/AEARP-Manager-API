package ao.sting.aearp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ao.sting.aearp.repository.Students;
import ao.sting.aearp.model.Student;

@Service
public class StudentService {
	
	@Autowired
	private Students students;
	
	public Iterable<Student> getAllStudents(){
		return students.findAll();
	}
	
	public Student saveStudent(Student student) {
		return students.save(student);
	}
	
	public Student deleteStudent(Student student) {
		students.delete(student);
		return student;
	}
	

}
