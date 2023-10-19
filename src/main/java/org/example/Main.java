package org.example;

import java.util.List;
import org.example.comparation.StudentComparable;
import org.example.comparation.UniversityComparable;
import org.example.enums.StudentComparator;
import org.example.enums.UniversityComparator;

public class Main {

    public static void main(String[] args) {

        List<University> universities =
                FileReader.readUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparable universityComparable =
                Utility.getUniversityComparator(UniversityComparator.YEAR_OF_FOUNDATION_COMPARATOR);
        universities.stream()
                .sorted(universityComparable)
                .forEach(System.out::println);

        List<Student> students =
                FileReader.readStudents("src/main/resources/universityInfo.xlsx");
        StudentComparable studentComparable =
                Utility.getStudentComparator(StudentComparator.AVG_EXAM_SCORE_COMPARATOR);
        students.stream()
                .sorted(studentComparable)
                .forEach(System.out::println);
    }
}