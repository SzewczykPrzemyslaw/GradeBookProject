package com.example.challenge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    static Calculator calculator;

    @ParameterizedTest
    @MethodSource("fileProvider")
    @DisplayName("Testing average from different files.")
    void findBestAverage(String expectedResult, Calculator calculator){
        assertEquals(expectedResult, calculator.findBestAverage());
    }

    private static Stream<Arguments> fileProvider(){
        return Stream.of(
                Arguments.of("3A, 4.083333333333333", calculator = new Calculator("grades.txt")),
                Arguments.of("1A, 4.1875", calculator = new Calculator("grades_2.txt"))
        );
    }

    @ParameterizedTest
    @MethodSource("incorrectFileNameProvider")
    @DisplayName("Testing incorrect file extensions")
    void findBestAverage_IncorrectFileName(String expectedResult, Calculator calculator){
        assertEquals(expectedResult, calculator.findBestAverage());
    }

    private static Stream<Arguments> incorrectFileNameProvider(){
        return Stream.of(
                Arguments.of("Something went wrong, check if file extension is correct.", calculator = new Calculator("grades.tx")),
                Arguments.of("Something went wrong, check if file extension is correct.", calculator = new Calculator("grades.jpg")),
                Arguments.of("Something went wrong, check if file extension is correct.", calculator = new Calculator("grades.jar")),
                Arguments.of("Something went wrong, check if file extension is correct.", calculator = new Calculator("grades.txtt")),
                Arguments.of("Something went wrong, check if file extension is correct.", calculator = new Calculator("grades.")),
                Arguments.of("Something went wrong, check if file extension is correct.", calculator = new Calculator("grades"))
        );
    }


}
