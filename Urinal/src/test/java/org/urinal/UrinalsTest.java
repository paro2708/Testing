package org.urinal;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    @Test
    void countUrinals_Test1() {
        System.out.println("====== Paromita Roy == TEST ONE EXECUTED =======");
        Urinals urinals = new Urinals();
        String testString = "101010";
        assertEquals(0, urinals.countUrinals(testString));
    }

    @Test
    void countUrinals_Test2() {
        System.out.println("====== Paromita Roy == TEST TWO EXECUTED =======");
        Urinals urinals = new Urinals();
        String testString = "00000";
        assertEquals(3, urinals.countUrinals(testString));
    }

    @Test
    void countUrinals_Test3() {
        System.out.println("====== Paromita Roy == TEST THREE EXECUTED =======");
        Urinals urinals = new Urinals();
        String testString = "1001";
        assertEquals(0, urinals.countUrinals(testString));
    }

    @Test
    void validateInput_Test4() {
        System.out.println("====== Paromita Roy == TEST FOUR EXECUTED =======");
        Urinals urinals = new Urinals();
        String testString = "aabbcc";
        assertFalse(urinals.validateInput(testString));
    }

    @Test
    void validateInput_Test5() {
        System.out.println("====== Paromita Roy == TEST FIVE EXECUTED =======");
        Urinals urinals = new Urinals();
        String testString = "101010101010101010101";
        assertFalse(urinals.validateInput(testString));
    }

    @Test
    void validateInput_Test6() {
        System.out.println("====== Paromita Roy == TEST SIX EXECUTED =======");
        Urinals urinals = new Urinals();
        String testString = "011";
        assertFalse(urinals.validateInput(testString));
    }

    @Test
    void countUrinals_Test7() {
        System.out.println("====== Paromita Roy == TEST SEVEN EXECUTED =======");
        Urinals urinals = new Urinals();
        String testString = "0000";
        assertEquals(2, urinals.countUrinals(testString));
    }

    @Test
    void validateInput_Test8() {
        System.out.println("====== Paromita Roy == TEST EIGHT EXECUTED =======");
        Urinals urinals = new Urinals();
        String testString = "0101";
        assertTrue(urinals.validateInput(testString));
    }

    @Test
    void validateFileName_Test9() {
        System.out.println("====== Paromita Roy == TEST NINE EXECUTED =======");
        Urinals urinals = new Urinals();
        Exception thrown = assertThrows(
                Exception.class,
                () -> urinals.getString("abc.dat"),
                "Should have thrown file not found exception, but didn't");
        System.out.println(thrown.getMessage());
        assertTrue(thrown.getMessage().contains("File not found"));
    }
}