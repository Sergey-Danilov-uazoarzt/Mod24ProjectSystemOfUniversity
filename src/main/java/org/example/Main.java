package org.example;

import org.example.utils.JsonUtil;
import org.example.utils.StatisticsUtil;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<University> universities =
                FileReader.readUniversities("src/main/resources/universityInfo.xlsx");

        List<Student> students =
                FileReader.readStudents("src/main/resources/universityInfo.xlsx");

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
            University universityFromJsonDeserializer =
                    JsonUtil.universityFromJsonDeserializer(universityToJsonSerializer);
            System.out.println(universityFromJsonDeserializer);
        });

        List<Statistics> statistics = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.writeStatistics(statistics, "src/main/resources/Statistics.xlsx");
  }
}
