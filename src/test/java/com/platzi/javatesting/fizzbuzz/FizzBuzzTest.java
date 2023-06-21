package com.platzi.javatesting.fizzbuzz;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {
    @Test
    public void if_number_is_divisible_by_three_then_fizz() {
        Assert.assertEquals("Fizz",FizzBuzz.fizzBuzz(3));
    }
    @Test
    public void if_number_is_divisible_by_five_then_buzz() {
        Assert.assertEquals("Buzz",FizzBuzz.fizzBuzz(5));
    }
    @Test
    public void if_number_is_divisible_by_five_and_three_then_fizzBuzz() {
        Assert.assertEquals("FizzBuzz",FizzBuzz.fizzBuzz(15));
    }

    @Test
    public void if_number_is_less_than_zero() {
        Assert.assertEquals("FizzBuzz",FizzBuzz.fizzBuzz(-5));
    }
}