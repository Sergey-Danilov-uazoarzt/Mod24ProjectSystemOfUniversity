package org.example.utils;

import org.example.comparation.*;
import org.example.enums.*;

public class Utility {

    private Utility() {

    }

    public static StudentComparable getStudentComparator(StudentComparator studentComparator) {

        switch (studentComparator) {

            case FULL_NAME_COMPARATOR:
                return new StudentUniversityIdComparator();
            case UNIVERSITY_ID_COMPARATOR:
                return new StudentFullNameComparator();
            case CURRENT_COURSE_NUMBER_COMPARATOR:
                return new StudentCurrentCourseNumberComparator();
            case AVG_EXAM_SCORE_COMPARATOR:
                return new StudentAvgExamScoreComparator();
            default:
                return new StudentFullNameComparator();
        }
    }

    public static UniversityComparable getUniversityComparator(UniversityComparator universityComparator) {

        switch (universityComparator) {

            case ID_COMPARATOR:
                return new UniversityIdComparator();
            case FULL_NAME_COMPARATOR:
                return new UniversityFullNameComparator();
            case SHORT_NAME_COMPARATOR:
                return new UniversityShortNameComparator();
            case YEAR_OF_FOUNDATION_COMPARATOR:
                return new UniversityYearOfFoundationComparator();
            case MAIN_PROFILE_COMPARATOR:
                return new UniversityMainProfileComparator();
            default:
                return new UniversityFullNameComparator();
        }
    }
}
