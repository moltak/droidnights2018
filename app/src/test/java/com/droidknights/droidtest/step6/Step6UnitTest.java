package com.droidknights.droidtest.step6;

import com.droidknights.droidtest.ViewModel;
import com.jakewharton.rxrelay2.Relay;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import javax.inject.Inject;

import retrofit2.Response;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Step6UnitTest {
    @Inject ViewModel viewModel;

    @Inject Relay<Response<String>> httpChannel;

    private CountDownLatch latch;

    @Before public void setUp() {
        DaggerStep6UnitTestComponent.builder()
                .step6UnitTestModule(new Step6UnitTestModule())
                .build()
                .inject(this);

        latch = new CountDownLatch(1);
    }

    @Test public void plusTest() throws InterruptedException {
        AtomicReference<String> res = new AtomicReference<>();

        httpChannel.subscribe(
                result -> {
                    res.set(result.body());
                    latch.countDown();
                },
                err -> latch.countDown());

        viewModel.calculate("1+1");

        latch.await();

        assertThat(res.get()).isEqualTo("2");
    }
}
