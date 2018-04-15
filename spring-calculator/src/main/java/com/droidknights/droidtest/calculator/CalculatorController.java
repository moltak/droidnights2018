package com.droidknights.droidtest.calculator;

import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    private final Step3Calculator calculator = new Step3GeneralCalculator();

    @RequestMapping(value="/calculate", method = RequestMethod.GET)
    @ResponseBody
    public String calculate(@RequestParam("expression") String expression) {
        return calculator.calculate(expression);
    }
}