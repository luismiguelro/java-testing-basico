package com.platzi.javatesting.romannumbers;

import java.util.Arrays;
import java.util.List;

public class RomanNumerals {
    //Lista de simbolos
    enum romanNumeral {
        M(1000),CM(900),D(500),CD(400),
        C(100),XC(90),L(50),XL(40),
        X(10),IX(9),V(5),IV(4),
        I(1);

        private int value;

        // constructor

        romanNumeral(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        // lista de los numeros
        public static List<romanNumeral> getRomanNumerals(){
            return Arrays.asList(romanNumeral.values());
        }

        //metodo de cambios

        public static String arabicToRoman(int n){
            StringBuilder collator = new StringBuilder();

            List<romanNumeral> romanNumerals = romanNumeral.getRomanNumerals();

            //validar que el numero sea menor a 4000 debido a que el formato cambia

            if(n>0 && n<4000){
                int index = 0; //
                while (n>0 && index<romanNumerals.size()){
                    romanNumeral currentRoman = romanNumerals.get(index);

                    //validar
                    if (n>= currentRoman.getValue()){
                        collator.append(currentRoman);
                        n-= currentRoman.getValue();
                    } else{
                        index++;
                    }
                }
                String roman = collator.toString();
                return  roman;
            } else {
                throw new IllegalArgumentException( n + "no está en el rango (0,4000)");
            }

        }

    }

}
