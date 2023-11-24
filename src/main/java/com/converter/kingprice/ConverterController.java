package com.converter.kingprice;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://www.kingprice.getpractical.co.za", "http://localhost:4200", "http://0.0.0.0:4200", "http://king-price-ui.s3-website.af-south-1.amazonaws.com/"})
@RestController
@RequestMapping("/converter")
public class ConverterController {

    private static final double METERS_TO_FEET_CONVERSION_FACTOR = 3.281;
    private static final double KILOGRAMS_TO_POUNDS_CONVERSION_FACTOR = 2.205;
    private static final double CELSIUS_TO_FAHRENHEIT_CONVERSION_FACTOR = 9.0 / 5.0;

    @GetMapping("/length-to-imperial/{metricValue}")
    public double convertLengthToImperial(@PathVariable double metricValue) {
        return convertLength(metricValue, METERS_TO_FEET_CONVERSION_FACTOR);
    }

    @GetMapping("/length-to-metric/{imperialValue}")
    public double convertLengthToMetric(@PathVariable double imperialValue) {
        return convertLength(imperialValue, 1.0 / METERS_TO_FEET_CONVERSION_FACTOR);
    }

    @GetMapping("/weight-to-imperial/{metricValue}")
    public double convertWeightToImperial(@PathVariable double metricValue) {
        return convertWeight(metricValue, KILOGRAMS_TO_POUNDS_CONVERSION_FACTOR);
    }

    @GetMapping("/weight-to-metric/{imperialValue}")
    public double convertWeightToMetric(@PathVariable double imperialValue) {
        return convertWeight(imperialValue, 1.0 / KILOGRAMS_TO_POUNDS_CONVERSION_FACTOR);
    }

    @GetMapping("/temperature-to-imperial/{metricValue}")
    public double convertTemperatureToImperial(@PathVariable double metricValue) {
        return convertTemperature(metricValue, CELSIUS_TO_FAHRENHEIT_CONVERSION_FACTOR, 32);
    }

    @GetMapping("/temperature-to-metric/{imperialValue}")
    public double convertTemperatureToMetric(@PathVariable double imperialValue) {
        return convertTemperature(imperialValue, 1.0 / CELSIUS_TO_FAHRENHEIT_CONVERSION_FACTOR, -32);
    }

    private double convertLength(double value, double conversionFactor) {
        return value * conversionFactor;
    }

    private double convertWeight(double value, double conversionFactor) {
        return value * conversionFactor;
    }

    private double convertTemperature(double value, double conversionFactor, double offset) {
        return (value * conversionFactor) + offset;
    }
}
