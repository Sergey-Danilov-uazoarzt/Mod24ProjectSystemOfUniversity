package org.example;

import java.util.List;

import org.example.comparation.StudentComparable;
import org.example.comparation.UniversityComparable;
import org.example.enums.StudentComparator;
import org.example.enums.UniversityComparator;
import org.example.utils.*;

public class Main {

    public static void main(String[] args) {

        List<University> universities =
                FileReader.readUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparable universityComparable =
                Utility.getUniversityComparator(UniversityComparator.YEAR_OF_FOUNDATION_COMPARATOR);
        universities.stream().sorted(universityComparable);

        System.out.println();

        List<Student> students =
                FileReader.readStudents("src/main/resources/universityInfo.xlsx");
        StudentComparable studentComparable =
                Utility.getStudentComparator(StudentComparator.AVG_EXAM_SCORE_COMPARATOR);
        students.stream().sorted(studentComparable);

        System.out.println();

        System.out.println("\nNext output is list of students\n");
        String studentsToJsonSerializer = JsonUtil.studentsToJsonSerializer(students);
        System.out.println(studentsToJsonSerializer);
        System.out.println("-------------------------------------------------------------");
        List<Student> studentsFromJsonDeserializer = JsonUtil.studentsFromJsonDeserializer(studentsToJsonSerializer);

        for (Student student : studentsFromJsonDeserializer) {
            System.out.println(student);
        }

        if(students.size() == studentsFromJsonDeserializer.size()) {
            System.out.println("\nLists are identical\n");
        } else {
            System.out.println("\nLists are different\n");
        }

        students.forEach(student -> {
          String studentToJsonSerializer = JsonUtil.studentToJsonSerializer(student);
          System.out.println(studentToJsonSerializer);
            Student studentFromJsonDeserializer = JsonUtil.studentFromJsonDeserializer(studentToJsonSerializer);
            System.out.println(studentFromJsonDeserializer);
        });

        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("\nNext output is list of universities\n");
        String universitiesToJsonSerializer = JsonUtil.universitiesToJsonSerializer(universities);
        System.out.println(universitiesToJsonSerializer);
        System.out.println("-------------------------------------------------------------");
        List<University> universitiesFromJsonDeserializer = JsonUtil
                .universitiesFromJsonDeserializer(universitiesToJsonSerializer);

        for (University university : universitiesFromJsonDeserializer) {
            System.out.println(university);
        }

        if(universities.size() == universitiesFromJsonDeserializer.size()) {
            System.out.println("\nLists are identical\n");
        } else {
            System.out.println("\nLists are different\n");
        }

        universities.forEach(university -> {
            String universityToJsonSerializer = JsonUtil.universityToJsonSerializer(university);
            System.out.println(universityToJsonSerializer);
            University universityFromJsonDeserializer = JsonUtil.universityFromJsonDeserializer(universityToJsonSerializer);
            System.out.println(universityFromJsonDeserializer);
        });
  }
}
