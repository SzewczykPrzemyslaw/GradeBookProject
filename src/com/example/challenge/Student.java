package com.example.challenge;

import java.util.List;

public class Student {
    private String name;
    private String lastName;
    private SchoolClass schoolClass;
    private GradeBook gradeBook;

    public Student(String name, String lastName, SchoolClass schoolClass, GradeBook gradeBook) {
        this.name = name;
        this.lastName = lastName;
        this.gradeBook = gradeBook;
        addToSchoolClass(schoolClass);
    }

    private void addToSchoolClass(SchoolClass schoolClass) {
        schoolClass.getListOfStudents().add(this);
        double oldAverage = schoolClass.getClassAverage();
        schoolClass.setClassAverage((oldAverage + calculateAverage(gradeBook.getGrades())) / 2);
    }

    private double calculateAverage(List<Double> grades) {
        return grades.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(Double.NaN);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public GradeBook getGradeBook() {
        return gradeBook;
    }

    public void setGradeBook(GradeBook gradeBook) {
        this.gradeBook = gradeBook;
    }
}
