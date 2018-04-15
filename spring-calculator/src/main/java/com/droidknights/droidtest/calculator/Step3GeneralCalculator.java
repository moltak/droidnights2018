package com.droidknights.droidtest.calculator;

import java.util.Arrays;
import java.util.List;

public class Step3GeneralCalculator implements Step3Calculator {
    @Override
    public String calculate(String expression) {
        String symbol;

        if (expression.contains("+")) {
            symbol = "\\+";
        } else if (expression.contains("-")) {
            symbol = "-";
        } else if (expression.contains("*")) {
            symbol = "\\*";
        } else if (expression.contains("/")) {
            symbol = "/";
        } else {
            throw new RuntimeException("Not supported symbol");
        }

        List<String> arguments = Arrays.asList(expression.split(symbol));
        int result;

        switch (symbol) {
            case "\\+":
                result = plus(arguments);
                break;
            case "-":
                result = minus(arguments);
                break;
            case "\\*":
                result = multiply(arguments);
                break;
            case "/":
                result = divide(arguments);
                break;
            default: throw new RuntimeException("Not supported symbol");
        }

        return String.valueOf(result);
    }

    @Override
    public int plus(List<String> arguments) {
        return Integer.valueOf(arguments.get(0)) + Integer.valueOf(arguments.get(1));
    }

    @Override
    public int minus(List<String> arguments) {
        return Integer.valueOf(arguments.get(0)) - Integer.valueOf(arguments.get(1));
    }

    @Override
    public int multiply(List<String> arguments) {
        return (int) Math.pow(Integer.valueOf(arguments.get(0)), Integer.valueOf(arguments.get(1)));
    }

    @Override
    public int divide(List<String> arguments) {
        return Integer.valueOf(arguments.get(0)) / Integer.valueOf(arguments.get(1));
    }
}
