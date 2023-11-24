package com.converter.kingprice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ConverterControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ConverterController converterController;

    @InjectMocks
    private ConverterControllerTest converterControllerTest;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(converterControllerTest).build();
    }

    @Test
    void convertLengthToImperial() throws Exception {
        double metricValue = 1.0;
        double expectedResult = metricValue * ConverterController.METERS_TO_FEET_CONVERSION_FACTOR;

        mockMvc.perform(get("/converter/length-to-imperial/{metricValue}", metricValue))
                .andExpect(status().isOk())
                .andExpect(content().string(Double.toString(expectedResult)));
    }

    @Test
    void convertTemperatureToMetric() throws Exception {
        double imperialValue = 32.0;
        double expectedResult = (imperialValue - 32) * (1.0 / ConverterController.CELSIUS_TO_FAHRENHEIT_CONVERSION_FACTOR);

        mockMvc.perform(get("/converter/temperature-to-metric/{imperialValue}", imperialValue))
                .andExpect(status().isOk())
                .andExpect(content().string(Double.toString(expectedResult)));
    }

}
