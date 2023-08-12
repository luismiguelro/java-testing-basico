package com.platzi.javatesting.romannumbers;

import org.junit.Test;

import static com.platzi.javatesting.romannumbers.RomanNumerals.romanNumeral.arabicToRoman;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RomanNumeralsTest {
    @Test
    public void roman_number_five() {
        assertThat(arabicToRoman(5), is("V"));
    }

    @Test
    public void roman_number_three() {
        assertThat(arabicToRoman(450), is("CDL"));

    }
    @Test
    public void wrong_roman_number(){
        assertThrows(IllegalArgumentException.class,()->{
            arabicToRoman(4000);
        });
    }
}