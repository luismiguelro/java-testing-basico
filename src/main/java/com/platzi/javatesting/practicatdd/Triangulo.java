package com.platzi.javatesting.practicatdd;

public class Triangulo {

    public static boolean esEquilatero(double lado1, double lado2, double lado3) {
        // Compara si los tres lados son iguales (tolerancia para evitar problemas de precisión decimal)
        double tolerancia = 1e-10;
        return Math.abs(lado1 - lado2) < tolerancia && Math.abs(lado2 - lado3) < tolerancia;
    }
    public static boolean esEscaleno(double lado1, double lado2, double lado3) {
        // Compara si los tres lados son diferentes (tolerancia para evitar problemas de precisión decimal)
        double tolerancia = 1e-10;
        return Math.abs(lado1 - lado2) >= tolerancia
                && Math.abs(lado1 - lado3) >= tolerancia
                && Math.abs(lado2 - lado3) >= tolerancia;
    }

    public static boolean esIsosceles(double lado1, double lado2, double lado3) {
        // Comprueba si dos lados son iguales y el tercero es diferente (tolerancia para evitar problemas de precisión decimal)
        double tolerancia = 1e-10;
        return (Math.abs(lado1 - lado2) < tolerancia && Math.abs(lado1 - lado3) >= tolerancia)
                || (Math.abs(lado1 - lado3) < tolerancia && Math.abs(lado1 - lado2) >= tolerancia)
                || (Math.abs(lado2 - lado3) < tolerancia && Math.abs(lado1 - lado2) >= tolerancia);
    }

}
