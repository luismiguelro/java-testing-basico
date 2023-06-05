package com.platzi.javatesting.util;

import org.junit.Test;
import static com.platzi.javatesting.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {
    @Test
    public void weak_when_has_less_than_8_letters() {
        // comprobacion de JUnit
        assertEquals(WEAK,PasswordUtil.assessPassword("123aa!"));

    }

    @Test
    public void weak_when_has_only_letters() {
        // comprobacion de JUnit
        assertEquals(WEAK,PasswordUtil.assessPassword("abcdefghijADFSFF"));

    }

    @Test
    public void weak_when_has_letters_and_numbers() {
        // comprobacion de JUnit
        assertEquals(MEDIUM,PasswordUtil.assessPassword("abcdefghi1234j"));

    }
    @Test
    public void strong_when_has_letters_numbers_and_symbols() {
        assertEquals(STRONG, PasswordUtil.assessPassword("abcd123!"));
    }
}