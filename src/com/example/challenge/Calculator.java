package com.example.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Calculator {
    private Map<String, SchoolClass> mapOfClasses = new HashMap<>();

    private final String GRADE_REGEX = ".*\\p{Digit}";
    private final String FILE_REGEX = "([^\\s]+(\\.(?i)(txt))$)";

    public Calculator(String fileName) {
        if (fileName.matches(FILE_REGEX)) {
            try (BufferedReader dirFile = new BufferedReader(new FileReader(fileName))) {
                String input;
                while ((input = dirFile.readLine()) != null) {
                    String[] data = input.split(";");
                    List<Double> grades = new ArrayList<>(gradesProvider(data));
                    GradeBook gradeBook = new GradeBook(grades);
                    if (!mapOfClasses.containsKey(data[2])) {
                        List<Student> listOfStudents = new ArrayList<>();
                        SchoolClass schoolClass;
                        mapOfClasses.put(data[2], schoolClass = new SchoolClass(data[2], listOfStudents, calculateAverage(grades)));
                        Student student = new Student(data[0], data[1], schoolClass, gradeBook);
                    } else {
                        for (Map.Entry<String, SchoolClass> entry : mapOfClasses.entrySet()) {
                            if (entry.getKey().equals(data[2])) {
                                SchoolClass schoolClass = entry.getValue();
                                Student student = new Student(data[0], data[1], schoolClass, gradeBook);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("I'm sorry but this file extension is incorrect.");
        }
    }

    private List<Double> gradesProvider(String[] data) {
        return Arrays.stream(data)
                .filter(s -> s.matches(GRADE_REGEX))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    private double calculateAverage(List<Double> grades) {
        return grades.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(Double.NaN);
    }

    private double getBestAverage() {
        Map<String, Double> averages = new HashMap<>();
        for (Map.Entry<String, SchoolClass> entry : mapOfClasses.entrySet()) {
            averages.put(entry.getKey(), entry.getValue().getClassAverage());
        }
        return Collections.max(averages.values());
    }

    public String findBestAverage() {
        double bestAverage = getBestAverage();
        for (Map.Entry<String, SchoolClass> entry : mapOfClasses.entrySet()) {
            if (entry.getValue().getClassAverage().equals(bestAverage)) {
                return entry.getKey() + ", " + entry.getValue().getClassAverage();
            }
        }
        return "Something went wrong, check if file extension is correct.";
    }
}

