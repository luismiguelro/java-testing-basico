package com.platzi.javatesting.util;

public class DateUtil {

    //Validar si un año es bisiesto
    public static boolean isLeapYear(int year){

        /*Refactor 2*/
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        /*Refactor 1
        if ((year % 4 == 0 && year % 100 !=0) || (year % 400 ==0)){
            return true;
        } else {
            return false;
        }

         */

        /* Construir con base a TDD

        // validar: Todos los años divisibles por 4, pero NO por 100. son bisiestos (1996, 2004, 2012)
        if (year % 4 == 0 && year % 100 !=0){
            return true;
        }

        //validar: Todos los años divisibles por 400 son bisiestos (1600, 2000, 2400)
        if(year % 400 ==0){
            return true;
        } else {
            return false;
        */

    }
}
