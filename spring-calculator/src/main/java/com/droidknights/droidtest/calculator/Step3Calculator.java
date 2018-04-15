package com.droidknights.droidtest.calculator;

import java.util.List;

public interface Step3Calculator {
    String calculate(String expression);

    int plus(List<String> arguments);

    int minus(List<String> arguments);

    int multiply(List<String> arguments);

    int divide(List<String> arguments);
}
