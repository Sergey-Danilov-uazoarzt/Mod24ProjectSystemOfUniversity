package org.example.comparation;

import org.example.University;

public class UniversityYearOfFoundationComparator implements UniversityComparable {

    public int compare (University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }
}