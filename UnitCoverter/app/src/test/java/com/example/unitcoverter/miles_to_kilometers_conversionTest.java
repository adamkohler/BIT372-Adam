package com.example.unitcoverter;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class miles_to_kilometers_conversionTest {
    @Test
    public void miles_conversion_isCorrect() {
        assertEquals(16.09, milesTokilometers_conversion.toKilo(10), .01);
    }
    @Test
    public void miles_conversion_isCorrect2() {
        assertEquals(1.61, milesTokilometers_conversion.toKilo(1), .01);
    }
}
