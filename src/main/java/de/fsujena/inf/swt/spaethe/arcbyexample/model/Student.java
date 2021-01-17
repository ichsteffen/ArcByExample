package de.fsujena.inf.swt.spaethe.arcbyexample.model;

import lombok.*;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 
 * Simple student POJO with few fields
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = -8582553475226281591L;

    @NotNull(message = "Student ID is required.")
    @Min(value = 1000, message = "Student ID must be at least 4 digits.")
    @Id
    private Integer id;

    @NotNull(message = "Student name is required.")
    private String name;

    @NotNull(message = "Student gender is required.")
    private Character gender;

    private Float percentage;

    private String matrikelnummer = "";
}
