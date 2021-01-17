package de.fsujena.inf.swt.spaethe.arcbyexample.restcontroller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StudentDTO {
    private Integer id;
    private String name;
    private Character gender;
    private Float percentage;

    static public StudentDTO fromModel(de.fsujena.inf.swt.spaethe.arcbyexample.domain.Student student) {
        return new StudentDTOBuilder()
                .id(student.getId())
                .name(student.getName())
                .gender(student.getGender())
                .percentage(student.getPercentage())
            .build();

    }
}
