package com.droidknights.droidtest.step3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Step3UnitTest 에서는 Calculator를 interface와 class(구현체)로 나눴습니다. 이 단계 후로 우리는 Calculator의 </br>
 * 구현체를 여러개 만들어서 다른 행동을 하도록 코딩할 수 있습니다. 그래서 *(곱하기) 를 ^(제곱)으로 변경하였습니다. </br>
 * Step4에서는 아예 새로운 Calculator가 등장합니다.
 */
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
