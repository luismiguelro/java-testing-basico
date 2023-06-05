package com.platzi.javatesting.util;
import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    // inidicar que es un test
    @Test
    public void repeat_string_once() {

        // Prueba 1
        // Comprobar mediante una funcion de JUnit
        Assert.assertEquals("Hola",StringUtil.repeat("Hola",1));

    }

    @Test
    public void repeat_string_multiple_times() {
        // Prueba 2
        // Comprobar mediante una funcion de JUnit
        Assert.assertEquals("HolaHolaHola",StringUtil.repeat("Hola",3));
    }

    @Test
    public void repeat_string_zero_times() {
        // Prueba 3
        // Comprobar mediante una funcion de JUnit
        Assert.assertEquals("",StringUtil.repeat("Hola",0));
    }
    //esperar excepcion
    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times() {
        // Prueba 3
        // Comprobar mediante una funcion de JUnit
        StringUtil.repeat("Hola",-1);
    }
}