package com.example.challenge;

import java.util.List;

public class SchoolClass {
    private String className;
    private List<Student> listOfStudents;
    private double classAverage;

    public SchoolClass(String className, List<Student> listOfStudents, Double classAverage) {
        this.className = className;
        this.listOfStudents = listOfStudents;
        this.classAverage = classAverage;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public Double getClassAverage() {
        return classAverage;
    }

    public void setClassAverage(Double classAverage) {
        this.classAverage = classAverage;
    }
}
