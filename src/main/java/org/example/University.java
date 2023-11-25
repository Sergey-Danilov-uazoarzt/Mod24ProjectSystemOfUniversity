package org.example;

import com.google.gson.annotations.SerializedName;
import org.example.enums.StudyProfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
public class University implements Serializable {

    @SerializedName("Номер университета")
    @XmlElement(name = "universityId")
    private String id;
    @SerializedName("Полное название")
    @XmlElement(name = "universityName")
    private String fullName;
    @SerializedName("Сокращённое название")
    @XmlTransient
    private String shortName;
    @SerializedName("Год основания")
    @XmlTransient
    private int yearOfFoundation;
    @SerializedName("Основной профиль образования")
    private StudyProfile mainProfile;

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public University() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Университет, номер университета: ").append(id).append("; полное название: ")
                .append(fullName).append("; краткое название: ").append(shortName).append("; год основания: ")
                .append(yearOfFoundation).append("; основной профиль обучения: ")
                .append(mainProfile.getProfileName());
        return builder.toString();
    }

    public boolean doQualityCheck() {
        return (id != null && !id.trim().isEmpty()) && (fullName != null && !fullName.trim().isEmpty())
                && (shortName != null && !shortName.trim().isEmpty())
                && (yearOfFoundation != 0) && (mainProfile != null);
    }
}