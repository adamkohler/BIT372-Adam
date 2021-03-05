package com.example.unitcoverter;

public class Converter {
    public static double toCelcius(float fah) {
        return (fah - 32) * 5/9;
    }

    public static double toMeter(double feet){
        return feet * 0.3048;
    }

    public static double toKilo(double miles){
        return miles * 1.609344;
    }

    public static double toKg(float pounds) {
        return pounds * 0.45359237;
    }
}
