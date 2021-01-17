package de.fsujena.inf.swt.spaethe.arcbyexample.controller;

import javax.validation.Valid;

import de.fsujena.inf.swt.spaethe.arcbyexample.persistence.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.fsujena.inf.swt.spaethe.arcbyexample.model.Student;

/**
 * Handles requests for the student model.
 * 
 */
@Controller
public class StudentController {

    StudentRepository studentRepository;

    // Konstruktor basierte Dependency Injection
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public String saveStudent(@Valid @ModelAttribute Student student, BindingResult errors, Model model) {
        if (!errors.hasErrors()) {
            // speichere Studenten in der Datenbank
            studentRepository.save(student);

            // Auslesen aller Studenten
            Iterable<Student> students = studentRepository.findAll();
            model.addAttribute("students", students);
        }
        return ((errors.hasErrors()) ? "addStudent.html" : "listStudents.html");
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent.html";
    }

    @RequestMapping(value = "/listStudents", method = RequestMethod.GET)
    public String listStudent(Model model) {

        Iterable<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);

        return "listStudents.html";
    }

}
