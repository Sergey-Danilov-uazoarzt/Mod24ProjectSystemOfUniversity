package org.example;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Student implements Serializable {

    @SerializedName("Полное имя")
    @XmlElement(name = "studentName")
    private String fullName;
    @SerializedName("Номер университета")
    @XmlElement(name = "universityId")
    private String universityId;
    @SerializedName("Текущий курс")
    @XmlTransient
    private int currentCourseNumber;
    @SerializedName("Средняя оценка")
    @XmlElement(name = "avgScore")
    private float avgExamScore;

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public Student() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Студент, полное имя: ").append(fullName).append("; номер университета: ")
                .append(universityId).append("; текущий курс: ").append(currentCourseNumber)
                .append("; средняя оценка за экзамен: ").append(avgExamScore);
        return builder.toString();
    }

    public boolean doQualityCheck() {
        return (fullName != null && !fullName.trim().isEmpty())
                && (universityId != null && !universityId.trim().isEmpty())
                && (currentCourseNumber != 0)
                && (avgExamScore != 0);
    }
}