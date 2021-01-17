package de.fsujena.inf.swt.spaethe.arcbyexample.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    @org.junit.jupiter.api.Test
    void getBewertung() {
        Student student = new Student();
        student.setPercentage(95.0f);
        String bewertung = student.getBewertung();
        assertEquals("sehr gut", bewertung);
    }

    @Test
    void getBewertung_Negativ() {
        Student student = new Student();
        student.setPercentage(-10.0f);
        String bewertung = student.getBewertung();
        assertEquals("ungenügend", bewertung);
    }


}