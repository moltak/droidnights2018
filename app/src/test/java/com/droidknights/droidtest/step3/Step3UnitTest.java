package com.droidknights.droidtest.step3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Step3UnitTest {
    private Step3Calculator calculator = new Step3GeneralCalculator();

    @Test public void plusTest() {
        String result = calculator.calculate("1+1");
        assertThat(result).isEqualTo("2");
    }

    @Test public void minusTest() {
        String result = calculator.calculate("1-1");
        assertThat(result).isEqualTo("0");
    }

    @Test public void multiplyTest() {
        String result = calculator.calculate("3*2");
        assertThat(result).isEqualTo("9");
    }

    @Test public void divideTest() {
        String result = calculator.calculate("8/2");
        assertThat(result).isEqualTo("4");
    }
}
