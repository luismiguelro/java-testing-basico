package com.platzi.javatesting.fizzbuzz;

public class FizzBuzz {
    public static String fizzBuzz(int n) throws IllegalArgumentException {
        if (n <= 0) {
            throw new IllegalArgumentException("El número debe ser mayor que cero.");
        }

        if (n % 3 == 0 && n % 5 == 0) {
            return "FizzBuzz";
        } else if (n % 5 == 0) {
            return "Buzz";
        } else if (n % 3 == 0) {
            return "Fizz";
        } else {
            return String.valueOf(n);
        }
    }

}
