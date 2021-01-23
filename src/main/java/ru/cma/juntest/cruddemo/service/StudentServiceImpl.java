package ru.cma.juntest.cruddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cma.juntest.cruddemo.model.entity.Group;
import ru.cma.juntest.cruddemo.model.entity.Student;
import ru.cma.juntest.cruddemo.repository.GroupRepository;
import ru.cma.juntest.cruddemo.repository.StudentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository repository;
    private GroupRepository groupRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository,GroupRepository groupRepository) {
        this.repository = repository;
        this.groupRepository = groupRepository;
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        Group group = groupRepository.findByName(student.getGroup().getName());
        if(group==null){
            throw new EntityNotFoundException("There is no group with this name.");
        }

        student.setGroup(group);
        repository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        Optional<Student> student = repository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new EntityNotFoundException("Student with id: " + id + " not found");
        }

    }
}
