package com.droidknights.droidtest.step2;

import java.util.Arrays;
import java.util.List;

class Step2Calculator {
    String calculate(String expression) {
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
                result = Integer.valueOf(arguments.get(0)) + Integer.valueOf(arguments.get(1));
                break;
            case "-":
                result = Integer.valueOf(arguments.get(0)) - Integer.valueOf(arguments.get(1));
                break;
            case "\\*":
                result = Integer.valueOf(arguments.get(0)) * Integer.valueOf(arguments.get(1));
                break;
            case "/":
                result = Integer.valueOf(arguments.get(0)) / Integer.valueOf(arguments.get(1));
                break;
            default: throw new RuntimeException("Not supported symbol");
        }

        return String.valueOf(result);
    }
}
