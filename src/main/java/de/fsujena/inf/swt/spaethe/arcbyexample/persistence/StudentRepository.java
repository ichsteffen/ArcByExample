package de.fsujena.inf.swt.spaethe.arcbyexample.persistence;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

    List<StudentEntity> findByName(String name);

    StudentEntity findById(long id);
}
