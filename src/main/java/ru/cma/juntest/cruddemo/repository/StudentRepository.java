package ru.cma.juntest.cruddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cma.juntest.cruddemo.model.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
