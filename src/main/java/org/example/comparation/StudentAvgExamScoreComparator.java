package org.example.comparation;

import org.example.Student;

public class StudentAvgExamScoreComparator implements StudentComparable {

    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o2.getAvgExamScore(), o1.getAvgExamScore());
    }
}
