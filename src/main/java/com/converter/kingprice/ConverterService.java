package com.converter.kingprice;

import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    public double convertLength(String fromUnit, String toUnit, double userInput) {
        double fromFactor = getFactor(fromUnit);
        double toFactor = getFactor(toUnit);
        return (userInput * toFactor) / fromFactor;
    }

    public double convertWeight(String fromUnit, String toUnit, double userInput) {
        double fromFactor = getFactor(fromUnit);
        double toFactor = getFactor(toUnit);
        return (userInput * toFactor) / fromFactor;
    }

    public double convertTemperature(String fromUnit, String toUnit, double userInput) {
        double fromOffset = getOffset(fromUnit);
        double toOffset = getOffset(toUnit);
        double factor = getFactor(toUnit);
        return ((userInput - fromOffset) * factor) + toOffset;
    }

    public double getFactor(String unit) {
        switch (unit) {
            case "Meters":
                return 1;
            case "Inches":
                return 39.3701;
            case "Centimeters":
                return 100;
            case "Kilograms":
                return 1;
            case "Pounds":
                return 2.20462;
            case "Grams":
                return 1000;
            case "Celsius":
                return 0.56;
            case "Fahrenheit":
                return 1.8;
            case "Kelvin":
                return 0.56;
            default:
                throw new IllegalArgumentException("Invalid conversion unit: " + unit);
        }
    }

    public double getOffset(String unit) {
        switch (unit) {
            case "Celsius":
                return 0;
            case "Fahrenheit":
                return 32;
            case "Kelvin":
                return 273.15;
            default:
                return 0;
        }
    }
}
 
