package ru.cma.juntest.cruddemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.cma.juntest.cruddemo.model.entity.Student;
import ru.cma.juntest.cruddemo.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService repository;


    @PostMapping("/save")
    public String saveStudent(@Valid @ModelAttribute("newStudent") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addStudent";
        }
        repository.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/save")
    public String saveStudentPage(Model model) {
        model.addAttribute("newStudent", new Student());
        return "addStudent";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam("id") Long id) {
        repository.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String getAllStudents(Model modelMap) {
        List<Student> students = repository.getAllStudents();
        modelMap.addAttribute("studentsList", students);
        return "studentsPage";
    }


}
