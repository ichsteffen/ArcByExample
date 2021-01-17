package de.fsujena.inf.swt.spaethe.arcbyexample.controller;

import de.fsujena.inf.swt.spaethe.arcbyexample.domain.Bewertungsstrategie;
import de.fsujena.inf.swt.spaethe.arcbyexample.domain.Student;
import de.fsujena.inf.swt.spaethe.arcbyexample.domain.StudentPersistence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Handles requests for the student model.
 * 
 */
@Controller
public class StudentController {

    StudentPersistence studentRepository;

    Bewertungsstrategie bewertungsstrategie;

    // Konstruktor basierte Dependency Injection
    public StudentController(
            StudentPersistence studentRepository,
            Bewertungsstrategie bewertungsstrategie
    ) {
        this.studentRepository = studentRepository;
        this.bewertungsstrategie = bewertungsstrategie;
    }

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public String saveStudent(@Valid @ModelAttribute Student student, BindingResult errors, Model model) {
        if (!errors.hasErrors()) {
            // speichere Studenten in der Datenbank
            studentRepository.save(student);

            // Auslesen aller Studenten
            Iterable<Student> students = studentRepository.findAll();
            model.addAttribute("students", students);
            model.addAttribute("controller", this);
            model.addAttribute( "bewertung", bewertungsstrategie);

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
        model.addAttribute("controller", this);
        model.addAttribute( "bewertung", bewertungsstrategie);
        return "listStudents.html";
    }

    public String calcBewertung(Student student) {


        Float percentage = student.getPercentage();
        if (percentage > 90.0) {
            return "sehr gut";
        } else
        if (percentage > 80.0) {
            return "gut";
        } else
        if (percentage > 60.0) {
            return "befriedigend";
        } else {
            return "ungenügend";
        }
    }

    /* Statisch Methode, welche vom Template aus aufgerufen werden könnte.
       Technisch möglich, aber keine sehr schöne Variante. */
    /*
    public static String calcBewertung(Student student) {
        Float percentage = student.getPercentage();
        if (percentage > 90.0) {
            return "sehr gut";
        } else
        if (percentage > 80.0) {
            return "gut";
        } else
        if (percentage > 60.0) {
            return "befriedigend";
        } else {
            return "ungenügend";
        }
    }
    */
}
