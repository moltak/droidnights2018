package com.droidknights.droidtest.step2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Step2UnitTest {
    private Step2Calculator calculator = new Step2Calculator();

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
        assertThat(result).isEqualTo("6");
    }

    @Test public void divideTest() {
        String result = calculator.calculate("8/2");
        assertThat(result).isEqualTo("4");
    }
}
