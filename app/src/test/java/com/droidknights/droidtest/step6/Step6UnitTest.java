package com.droidknights.droidtest.step6;

import com.droidknights.droidtest.ViewModel;
import com.jakewharton.rxrelay2.Relay;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import io.reactivex.observers.TestObserver;
import retrofit2.Response;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
