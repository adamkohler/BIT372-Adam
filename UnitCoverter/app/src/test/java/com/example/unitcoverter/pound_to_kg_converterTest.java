package com.example.unitcoverter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class pound_to_kg_converterTest {

    @Test
    public void pound_conversion_isCorrect() {
        assertEquals(45359237, pound_to_kg_converter.toKg(100000000), 0.01);
    }
}
