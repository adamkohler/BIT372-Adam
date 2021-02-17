package com.example.unitcoverter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class feet_to_meter_converterTest {
    @Test
    public void feet_conversion_isCorrect() {
        assertEquals(30.48, feetTometer_conversion.toMeter(100), .01);
    }
    @Test
    public void feet_conversion_isCorrect2() {
        assertEquals(1.524, feetTometer_conversion.toMeter(5), .01);
    }
}
