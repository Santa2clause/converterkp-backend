package com.converter.kingprice;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {
    "http://www.kingprice.getpractical.co.za", 
    "http://localhost:4200", 
    "http://0.0.0.0:4200", 
    "http://king-price-ui.s3-website.af-south-1.amazonaws.com/"
})
@RestController
@RequestMapping("/converter")
public class ConverterController
{

    public final ConverterService converterService;

    public ConverterController(ConverterService converterService)
    {
        this.converterService = converterService;
    }

    @PostMapping("/length")
    public double convertLength(@RequestParam String fromUnit, @RequestParam String toUnit, @RequestParam double userInput) {
        return converterService.convertLength(fromUnit, toUnit, userInput);
    }

    @PostMapping("/weight")
    public double convertWeight(@RequestParam String fromUnit, @RequestParam String toUnit, @RequestParam double userInput) {
        return converterService.convertWeight(fromUnit, toUnit, userInput);
    }

    @PostMapping("/temperature")
    public double convertTemperature(@RequestParam String fromUnit, @RequestParam String toUnit, @RequestParam double userInput) {
        return converterService.convertTemperature(fromUnit, toUnit, userInput);
    }
}