package com.example.unitcoverter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ConverterTest {
    @Test
    public void fahrenheit_conversion_isCorrect() {
        assertEquals(0.0, Converter.toCelcius(32),0.01);
    }

    @Test
    public void feet_conversion_isCorrect() {
        assertEquals(30.48, Converter.toMeter(100), .01);
    }

    @Test
    public void feet_conversion_isCorrect2() {
        assertEquals(1.524, Converter.toMeter(5), .01);
    }

    @Test
    public void miles_conversion_isCorrect() {
        assertEquals(16.09, Converter.toKilo(10), .01);
    }

    @Test
    public void miles_conversion_isCorrect2() {
        assertEquals(1.61, Converter.toKilo(1), .01);
    }

    @Test
    public void pound_conversion_isCorrect() {
        assertEquals(45359237, Converter.toKg(100000000), 0.01);
    }


}