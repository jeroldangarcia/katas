package kata;

import static org.junit.Assert.*;

import org.junit.Test;

import kata.FizzBuzz;

public class TestFizzBuzz
{

    FizzBuzz fizzbuzz = new FizzBuzz();

    @Test public void shouldSayFizz() {
        assertEquals( "fizz", fizzbuzz.generate(3));
    }

    @Test public void shouldSayBuzz() {
        assertEquals( "buzz", fizzbuzz.generate(5));
    }

    @Test public void shouldSayFizzBuzz() { 
        assertEquals( "fizzbuzz", fizzbuzz.generate(15));
    }

}
