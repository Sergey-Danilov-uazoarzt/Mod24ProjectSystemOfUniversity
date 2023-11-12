package org.example;

import org.example.enums.StudyProfile;

public class Statistics {

    private StudyProfile mainProfile;
    private float avgExamScore;
    private int quantityOfStudentsByProfile;
    private int quantityOfUniversitiesByProfile;
    private String fullName;

    public Statistics() {
    }

    public Statistics(StudyProfile mainProfile, float avgExamScore, int quantityOfStudentsByProfile,
                      int quantityOfUniversitiesByProfile, String fullName) {
        this.mainProfile = mainProfile;
        this.avgExamScore = avgExamScore;
        this.quantityOfStudentsByProfile = quantityOfStudentsByProfile;
        this.quantityOfUniversitiesByProfile = quantityOfUniversitiesByProfile;
        this.fullName = fullName;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public int getQuantityOfStudentsByProfile() {
        return quantityOfStudentsByProfile;
    }

    public void setQuantityOfStudentsByProfile(int quantityOfStudentsByProfile) {
        this.quantityOfStudentsByProfile = quantityOfStudentsByProfile;
    }

    public int getQuantityOfUniversitiesByProfile() {
        return quantityOfUniversitiesByProfile;
    }

    public void setQuantityOfUniversitiesByProfile(int quantityOfUniversitiesByProfile) {
        this.quantityOfUniversitiesByProfile = quantityOfUniversitiesByProfile;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}