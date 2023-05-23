package com.platzi.javatesting.util;

public class StringUtilTest {
    public static void main(String[] args) {

        // Prueba 1 : Manera muy manual
        //Llamar funcion
        String result= StringUtil.repeat("Hola",3);
       // System.out.println(result);

        // comprobar resultado esperado
        if(result.equals("HolaHolaHola")){
            System.out.println("OK");
        }

        // Prueba 2
        String result2= StringUtil.repeat("Hola",1);
        // System.out.println(result2);

        // comprobar resultado esperado
        if(result2.equals("Hola")){
            System.out.println("OK");
        }
    }
}