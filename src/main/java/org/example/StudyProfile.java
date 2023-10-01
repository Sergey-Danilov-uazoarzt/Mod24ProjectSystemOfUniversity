package org.example;

public enum StudyProfile {

    MEDICINE("Медицина"),
    PROGRAMMING("Программирование"),
    CONSTRUCTION("Строительство");

    private String profileName;

    StudyProfile (String profileName) {
        this.profileName = profileName;
    }
}
