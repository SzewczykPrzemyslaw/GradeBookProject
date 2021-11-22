package com.example.challenge;

import java.util.List;

public class GradeBook {
    private List<Double> grades;
    private double average;

    public GradeBook(List<Double> grades) {
        this.grades = grades;
        this.average = calculateAverage(grades);
    }

    private double calculateAverage(List<Double> grades) {
        return grades.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(Double.NaN);
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }
}
