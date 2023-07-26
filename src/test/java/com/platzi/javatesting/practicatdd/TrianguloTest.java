package com.platzi.javatesting.practicatdd;

import org.junit.Assert;
import org.junit.Test;

public class TrianguloTest {
    @Test
    public void triangulo_equilatero() {
       Assert.assertTrue(Triangulo.esEquilatero(5,5,5));
    }

    @Test
    public void triangulo_escaleno() {
        Assert.assertTrue(Triangulo.esEscaleno(5,4,7));
    }

    @Test
    public void triangulo_isosceles() {
        Assert.assertTrue(Triangulo.esIsosceles(1,1,2));
    }



}