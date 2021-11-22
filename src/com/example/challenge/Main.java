package com.example.challenge;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator("grades.txt");
        System.out.println(calculator.findBestAverage());
    }
}
