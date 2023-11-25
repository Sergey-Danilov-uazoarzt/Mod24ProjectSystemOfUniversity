package org.example;

import org.example.enums.StudyProfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {

    @XmlElement(name = "universityProfile")
    private StudyProfile mainProfile;
    @XmlElement(name = "avgScore")
    private float avgExamScore;
    @XmlTransient
    private int quantityOfStudentsByProfile;
    @XmlTransient
    private int quantityOfUniversitiesByProfile;
    @XmlTransient
    private String fullName;

    public Statistics() {
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