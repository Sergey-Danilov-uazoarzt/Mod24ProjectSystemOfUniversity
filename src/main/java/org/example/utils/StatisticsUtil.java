package org.example.utils;

import org.apache.commons.lang3.StringUtils;
import org.example.Student;
import org.example.University;
import org.example.Statistics;
import org.example.enums.StudyProfile;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StatisticsUtil {

    private static final Logger logger = Logger.getLogger(StatisticsUtil.class.getName());

    private StatisticsUtil() {
    }

    public static List<Statistics> createStatistics(List<Student> students, List<University> universities) {

        logger.log(Level.INFO, "Statistics module started");

        List<Statistics> statistics = new ArrayList<>();

        Set<StudyProfile> profiles = universities.stream().map(University::getMainProfile).collect(Collectors.toSet());

        profiles.forEach(profile -> {
            Statistics data = new Statistics();
            statistics.add(data);
            data.setMainProfile(profile);

            List <String> profileUniversityIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId).collect(Collectors.toList());
            data.setQuantityOfUniversitiesByProfile(profileUniversityIds.size());
            data.setFullName(StringUtils.EMPTY);
            universities.stream().filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> data.setFullName(data.getFullName() + fullNameUniversity + ";"));
            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            data.setQuantityOfStudentsByProfile(profileStudents.size());
            OptionalDouble avgExamScore = profileStudents.stream().mapToDouble(Student::getAvgExamScore).average();
            data.setAvgExamScore(0);
            avgExamScore.ifPresent(value -> data.setAvgExamScore((float) BigDecimal.valueOf(value)
                    .setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });

        logger.log(Level.INFO, String.format("Statistics module finished with %s statistical objects",
                statistics.size()));

        return statistics;
    }
}
