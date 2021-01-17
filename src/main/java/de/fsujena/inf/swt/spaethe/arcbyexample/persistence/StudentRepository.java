package de.fsujena.inf.swt.spaethe.arcbyexample.persistence;

import de.fsujena.inf.swt.spaethe.arcbyexample.model.Student;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    List<Student> findByName(String name);

    Student findById(long id);
}
