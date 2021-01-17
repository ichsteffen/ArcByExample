package de.fsujena.inf.swt.spaethe.arcbyexample.persistence;

import de.fsujena.inf.swt.spaethe.arcbyexample.domain.Student;
import de.fsujena.inf.swt.spaethe.arcbyexample.domain.StudentPersistence;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


/** Implementierung des Domain-Repository */
@Component
class StudentPersistenceJPA implements StudentPersistence {

    private final StudentRepository studentRepository;

    public StudentPersistenceJPA(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(Student student) {
        StudentEntity studentEntity = StudentEntity.fromDomain(student);
        studentRepository.save(studentEntity);
    }

    @Override
    public Iterable<Student> findAll() {
        Iterable<StudentEntity> studentEntities = studentRepository.findAll();

        Iterable<Student> result =
                StreamSupport.stream(studentEntities.spliterator(), false)
                .map(StudentEntity::toDomain)
                .collect(Collectors.toList());

        return result;
    }

    public Optional<Student> findById(Integer id) {
        Optional<StudentEntity> studentEntityOptional = studentRepository.findById(id);
        if (studentEntityOptional.isPresent()) {
            StudentEntity studentEntity = studentEntityOptional.get();
            Optional<Student> student = Optional.of(studentEntity.toDomain());
            return student;
        } else {
            return Optional.ofNullable(null);
        }
    }
}
