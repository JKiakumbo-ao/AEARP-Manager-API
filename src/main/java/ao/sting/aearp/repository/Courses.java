package ao.sting.aearp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ao.sting.aearp.model.Course;

public interface Courses extends JpaRepository<Course, Long> {

}
