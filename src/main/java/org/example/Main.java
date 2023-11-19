package org.example;

import org.example.comparation.StudentComparable;
import org.example.comparation.UniversityComparable;
import org.example.enums.StudentComparator;
import org.example.enums.UniversityComparator;
import org.example.utils.StatisticsUtil;
import org.example.utils.Utility;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        try {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        logger.log(INFO, "Application started, Logger configured");

        List<University> universities =
                FileReader.readUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparable universityComparator =
                Utility.getUniversityComparator(UniversityComparator.YEAR_OF_FOUNDATION_COMPARATOR);
        universities.sort(universityComparator);

        List<Student> students =
                FileReader.readStudents("src/main/resources/universityInfo.xlsx");
        StudentComparable studentComparator =
                Utility.getStudentComparator(StudentComparator.AVG_EXAM_SCORE_COMPARATOR);
        students.sort(studentComparator);

        List<Statistics> statistics = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.writeStatistics(statistics, "statistics.xlsx");

        FullInfo fullInfo = new FullInfo()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statistics)
                .setProcessDate(new Date());

        XmlWriter.generateXmlReq(fullInfo);
        JsonWriter.writeJsonReq(fullInfo);

        logger.log(INFO, "Application finished");
  }
}
