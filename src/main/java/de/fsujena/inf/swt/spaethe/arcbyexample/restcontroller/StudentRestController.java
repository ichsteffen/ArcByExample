package de.fsujena.inf.swt.spaethe.arcbyexample.restcontroller;

import de.fsujena.inf.swt.spaethe.arcbyexample.model.Student;
import de.fsujena.inf.swt.spaethe.arcbyexample.persistence.StudentRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController()
@RequestMapping("/rest")
public class StudentRestController {

    private final StudentRepository studentRepository;

    public StudentRestController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return  String.format("Hello %s", name);
    }

    @GetMapping(path="/student/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Student getStudentById(@PathVariable Integer id, HttpServletResponse response) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
    }
}
