package de.fsujena.inf.swt.spaethe.arcbyexample.persistence;

import de.fsujena.inf.swt.spaethe.arcbyexample.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
class StudentEntity {

    @Id
    private Integer id;
    private String name;
    private Character gender;
    private Float percentage;
    private String matrikelnummer = "";
    private long geburtstagEpochSec;

    public Student toDomain() {
        Student student = new Student(
                this.id,
                this.name,
                this.gender,
                this.percentage,
                this.matrikelnummer,
                this.geburtstagEpochSec != 0 ? Instant.ofEpochSecond(geburtstagEpochSec) : null
        );
        return student;
    }

    static StudentEntity fromDomain(Student student) {
        StudentEntity studentEntity = new StudentEntity(
                student.getId(),
                student.getName(),
                student.getGender(),
                student.getPercentage(),
                student.getMatrikelnummer(),
                student.getGeburtstag() == null ? 0 : student.getGeburtstag().getEpochSecond()
            );
        return studentEntity;

        /* Alternativ mittels Builder ...

        new StudentEntityBuilder()
                .id(student.getId())
                .gender(student.getGender())
                .name(student.getName())
                .percentage(student.getPercentage())
                .matrikelnummer(student.getMatrikelnummer())
                .geburtstagEpochSec(
                        student.getGeburtstag() == null ? 0 : student.getGeburtstag().getEpochSecond()
                ).build();
         */
    }

}