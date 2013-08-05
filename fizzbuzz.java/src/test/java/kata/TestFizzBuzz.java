package kata;

import static org.junit.Assert.*;

import org.junit.Test;

import kata.FizzBuzz;

public class TestFizzBuzz
{

    FizzBuzz fizzbuzz = new FizzBuzz();

    @Test public void shouldSayFizz() {
        assertEquals( "fizz", fizzbuzz.generate(3));
        assertEquals( "fizz", fizzbuzz.generate(6));
        assertEquals( "fizz", fizzbuzz.generate(9));
    }

    @Test public void shouldSayBuzz() {
        assertEquals( "buzz", fizzbuzz.generate(5));
        assertEquals( "buzz", fizzbuzz.generate(10));
        assertEquals( "buzz", fizzbuzz.generate(20));
    }

    @Test public void shouldSayFizzBuzz() { 
        assertEquals( "fizzbuzz", fizzbuzz.generate(15));
        assertEquals( "fizzbuzz", fizzbuzz.generate(30));
        assertEquals( "fizzbuzz", fizzbuzz.generate(45));
    }

}
