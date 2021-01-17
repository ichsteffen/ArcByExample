package de.fsujena.inf.swt.spaethe.arcbyexample.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = -8582553475226281591L;

    @NotNull(message = "Student ID is required.")
    @Min(value = 1000, message = "Student ID must be at least 4 digits.")
    private Integer id;

    @NotNull(message = "Student name is required.")
    private String name;

    @NotNull(message = "Student gender is required.")
    private Character gender;

    private Float percentage;

    private String matrikelnummer = "";

    private Instant geburtstag;

    public String getBewertung() {
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
}
