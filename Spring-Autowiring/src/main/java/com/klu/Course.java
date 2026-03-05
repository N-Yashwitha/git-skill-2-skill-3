package com.klu;

import org.springframework.stereotype.Component;

@Component
public class Course {

    private int id = 301;
    private String course = "FSAD";
    private String dateOfCompletion = "5-mar-2026";

    @Override
    public String toString() {
        return "Course [id=" + id +
               ", course=" + course +
               ", dateOfCompletion=" + dateOfCompletion + "]";
    }
}
