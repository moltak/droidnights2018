package com.droidknights.droidtest.step5;

import com.droidknights.droidtest.ViewModel;

import org.junit.Test;

import io.reactivex.observers.TestObserver;
import retrofit2.Response;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Step5UnitTest에서는 이전 테스트들이 해왔던 Calculator를 직접 호출하는 것을 ViewModel을 이용해 추상화합니다. 이를 통해, </br>
 * 우리는 calculate() 함수를 호출 했을 때, 어떤 곳 (여기서는 stream)으로 결과가 나온다는 것을 알 수 있게 됩니다. </br>
 * 이 구현을 통해 Calculator 가 다른 어떠한 것 심지어 존재하지 않아도 우리는 테스트 코드를 작성할 수 있게 됩니다. 이 말은 </br>
 * 테스트내에서 production 코드와 상관없이 Calculator 를 우리 마음대로 구현할 수 있다는 말입니다.
 */
public class Step5UnitTest {
    private ViewModel viewModel = new Step5ViewModel();

    @Test public void plusTest() {
        TestObserver<Response<String>> testObserver = TestObserver.create();

        ((Step5ViewModel) viewModel).getHttpStream().subscribe(testObserver);

        viewModel.calculate("1+1");

        String res = testObserver.awaitCount(1).values().get(0).body();

        assertThat(res).isEqualTo("2");
    }

    @Test public void minusTest() {
        TestObserver<Response<String>> testObserver = TestObserver.create();

        ((Step5ViewModel) viewModel).getHttpStream().subscribe(testObserver);

        viewModel.calculate("1-1");

        String res = testObserver.awaitCount(1).values().get(0).body();

        assertThat(res).isEqualTo("0");
    }

    @Test public void multiplyTest() {
        TestObserver<Response<String>> testObserver = TestObserver.create();

        ((Step5ViewModel) viewModel).getHttpStream().subscribe(testObserver);

        viewModel.calculate("3*2");

        String res = testObserver.awaitCount(1).values().get(0).body();

        assertThat(res).isEqualTo("9");
    }

    @Test public void divideTest() {
        TestObserver<Response<String>> testObserver = TestObserver.create();

        ((Step5ViewModel) viewModel).getHttpStream().subscribe(testObserver);

        viewModel.calculate("8/2");

        String res = testObserver.awaitCount(1).values().get(0).body();

        assertThat(res).isEqualTo("4");
    }
}
