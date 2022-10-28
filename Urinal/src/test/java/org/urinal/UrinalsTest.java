package org.urinal;

import org.junit.jupiter.api.Test;

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
    void validateInput_Test2() {
        System.out.println("====== Paromita Roy == TEST TWO EXECUTED =======");
        Urinals urinals = new Urinals();
        String testString = "aabbcc";
        assertEquals(false, urinals.validateInput(testString));
    }

    @Test
    void validateInput_Test3() {
        System.out.println("====== Paromita Roy == TEST THREE EXECUTED =======");
        Urinals urinals = new Urinals();
        String testString = "101010101010101010101";
        assertEquals(false, urinals.validateInput(testString));
    }

    @Test
    void validateInput_Test4() {
        System.out.println("====== Paromita Roy == TEST FOUR EXECUTED =======");
        Urinals urinals = new Urinals();
        String testString = "011";
        assertEquals(false, urinals.validateInput(testString));
    }
}