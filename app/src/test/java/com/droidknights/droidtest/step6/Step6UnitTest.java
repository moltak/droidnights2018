package com.droidknights.droidtest.step6;

import com.droidknights.droidtest.ViewModel;
import com.jakewharton.rxrelay2.Relay;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import io.reactivex.observers.TestObserver;
import retrofit2.Response;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Step6UnitTest 에서는 mocked Calculator를 사용해 테스트합니다. Step5를 통해 테스트코드와 Calculator 간의 관계를 </br>
 * 끊어 버렸습니다. Calculator의 모든 행동은 ViewModel이 추상화하게 됩니다. 이를 통해 우리는 테스트코드는 전혀 </br>
 * 눈치채지 못하게 Calculator 를 mocking 해버렸고 결과적으로 아주 빠른 속도로 테스트가 수행됩니다.
 */
public class Step6UnitTest {
    @Inject ViewModel viewModel;

    @Inject Relay<Response<String>> httpChannel;

    @Before public void setUp() {
        DaggerStep6UnitTestComponent.builder()
                .step6UnitTestModule(new Step6UnitTestModule())
                .build()
                .inject(this);
    }

    @Test public void plusTest() {
        TestObserver<Response<String>> testObserver = TestObserver.create();

        httpChannel.subscribe(testObserver);

        viewModel.calculate("1+1");

        String res = testObserver.awaitCount(1).values().get(0).body();

        assertThat(res).isEqualTo("2");
    }

    @Test public void minusTest() {
        TestObserver<Response<String>> testObserver = TestObserver.create();

        httpChannel.subscribe(testObserver);

        viewModel.calculate("1-1");

        String res = testObserver.awaitCount(1).values().get(0).body();

        assertThat(res).isEqualTo("0");
    }

    @Test public void multiplyTest() {
        TestObserver<Response<String>> testObserver = TestObserver.create();

        httpChannel.subscribe(testObserver);

        viewModel.calculate("3*2");

        String res = testObserver.awaitCount(1).values().get(0).body();

        assertThat(res).isEqualTo("9");
    }

    @Test public void divideTest() {
        TestObserver<Response<String>> testObserver = TestObserver.create();

        httpChannel.subscribe(testObserver);

        viewModel.calculate("8/2");

        String res = testObserver.awaitCount(1).values().get(0).body();

        assertThat(res).isEqualTo("4");
    }
}
