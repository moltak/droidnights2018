package com.droidknights.droidtest.step4;

import com.droidknights.droidtest.Calculator;
import com.droidknights.droidtest.step3.Step3Calculator;
import com.droidknights.droidtest.step3.Step3GeneralCalculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Step4UnitTest 는 Unit 테스트의 신속함을 잃어 버렸습니다. API server의 응답을 기다리기 위해 blockingGet()을 </br>
 * 호출 하고 있는데 이는 테스트를 매우 느리게 만듭니다. Step6 에서는 이를 해결합니다.
 */
public class Step4UnitTest {
    private Calculator calculator = new Step4CalculatorImpl();

    @Test public void plusTest() {
        String result = calculator.calculate("1+1").blockingGet().body();
        assertThat(result).isEqualTo("2");
    }

    @Test public void minusTest() {
        String result = calculator.calculate("1-1").blockingGet().body();
        assertThat(result).isEqualTo("0");
    }

    @Test public void multiplyTest() {
        String result = calculator.calculate("3*2").blockingGet().body();
        assertThat(result).isEqualTo("9");
    }

    @Test public void divideTest() {
        String result = calculator.calculate("8/2").blockingGet().body();
        assertThat(result).isEqualTo("4");
    }
}
