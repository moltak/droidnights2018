package com.droidknights.droidtest.step2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Step2UnitTest 에서는 Calculator를 class로 따로 떼어냈기 때문에 Unit 테스트를 작성할 수 있습니다.
 */
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
