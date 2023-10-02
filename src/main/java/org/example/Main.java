package org.example;

public class Main {

    public static void main(String[] args) {

        University rgmu = new University("1", "Российский государственный медицинский университет",
                "РГМУ", 1906, StudyProfile.MEDICINE);

        Student studentIvanov = new Student("Иванов Иван Иванович", "1",
                6, 4.5f);

        System.out.println(rgmu);
        System.out.println(studentIvanov);
  }
}
