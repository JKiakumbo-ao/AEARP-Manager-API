package ao.sting.aearp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ao.sting.aearp.model.Student;

@Repository
public interface Students extends JpaRepository<Student,Long> {

}
