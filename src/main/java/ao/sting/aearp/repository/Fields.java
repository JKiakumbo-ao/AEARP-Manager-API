package ao.sting.aearp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ao.sting.aearp.model.Field;

public interface Fields extends JpaRepository<Field, Long> {

}
