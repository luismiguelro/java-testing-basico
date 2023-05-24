package com.platzi.javatesting.util;

public class StringUtilTest {
    public static void main(String[] args) {

        // Prueba 1

        // Comprobar mediante una funcion
        assertEquals(StringUtil.repeat("Hola",3),"HolaHolaHola");


        // Prueba 1.1

        // Comprobar mediante una funcion
        assertEquals(StringUtil.repeat("Hola",1),"Hola");

    }


    private static void assertEquals(String actual, String expected) {
        // comprobar resultado esperado
        if(!actual.equals(expected)){
            throw new RuntimeException(actual + " is not equal to expected: "+expected);
        }
    }
}