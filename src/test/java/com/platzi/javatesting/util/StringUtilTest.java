package com.platzi.javatesting.util;
import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    // inidicar que es un test
    @Test
    public void testRepeat() {


        // Prueba 1

        // Comprobar mediante una funcion de JUnit
        Assert.assertEquals("HolaHolaHola",StringUtil.repeat("Hola",3));


        // Prueba 1.1

        // Comprobar mediante una funcion de JUnit
        Assert.assertEquals("Hola",StringUtil.repeat("Hola",1));

    }



}