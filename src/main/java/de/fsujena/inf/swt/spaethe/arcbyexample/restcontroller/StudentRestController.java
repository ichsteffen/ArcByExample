package de.fsujena.inf.swt.spaethe.arcbyexample.restcontroller;

import de.fsujena.inf.swt.spaethe.arcbyexample.domain.Student;
import de.fsujena.inf.swt.spaethe.arcbyexample.domain.StudentPersistence;
import de.fsujena.inf.swt.spaethe.arcbyexample.restcontroller.dto.StudentDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class StudentRestController {

    private final StudentPersistence studentPersistence;

    public StudentRestController(StudentPersistence studentPersistence) {
        this.studentPersistence = studentPersistence;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return  String.format("Hello %s", name);
    }

    @GetMapping(path="/student/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public StudentDTO getStudentById(@PathVariable Integer id, HttpServletResponse response) {
        Optional<Student> student = studentPersistence.findById(id);
        if (student.isPresent()) {
            StudentDTO studentDTO = StudentDTO.fromModel(student.get());
            return studentDTO;
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
    }
}
