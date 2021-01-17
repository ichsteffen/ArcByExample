package de.fsujena.inf.swt.spaethe.arcbyexample.domain;

import java.util.Optional;

public interface StudentPersistence {
    void save(Student student);
    Iterable<Student> findAll();
    Optional<Student> findById(Integer id);
}
