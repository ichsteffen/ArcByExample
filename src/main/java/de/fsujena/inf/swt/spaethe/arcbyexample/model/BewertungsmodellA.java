package de.fsujena.inf.swt.spaethe.arcbyexample.model;

import org.springframework.stereotype.Component;

@Component
public class BewertungsmodellA implements Bewertungsstrategie {

    public String calcBewertung(float percentage) {
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
