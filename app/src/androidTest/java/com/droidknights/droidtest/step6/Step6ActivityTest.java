package com.droidknights.droidtest.step6;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.droidknights.droidtest.CalculatorApplication;
import com.droidknights.droidtest.R;
import com.jakewharton.rxrelay2.Relay;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import javax.inject.Inject;

import retrofit2.Response;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class Step6ActivityTest {
    @Rule public ActivityTestRule<Step6Activity> testRule = new ActivityTestRule(Step6Activity.class, false, false);

    @Inject Relay<Response<String>> httpChannel;

    private CountDownLatch latch;

    @Before public void setUp() {
        CalculatorApplication application = (CalculatorApplication) InstrumentationRegistry.getTargetContext().getApplicationContext();

        Step6TestComponent testComponent = DaggerStep6TestComponent.builder()
                .testStep6Module(new Step6TestModule())
                .build();
        application.setStep6Component(testComponent);
        testComponent.inject(this);

        latch = new CountDownLatch(1);
    }

    @Test public void plusTest() throws InterruptedException {

        testRule.launchActivity(null);

        httpChannel.subscribe(
                        result -> latch.countDown(),
                        err -> latch.countDown());

        buttonClick(R.id.calculator_button_1);

        buttonClick(R.id.calculator_button_plus);

        buttonClick(R.id.calculator_button_1);

        buttonClick(R.id.calculator_button_result);

        latch.await();

        onView(withId(R.id.calculator_edit_text)).check(matches(withText("2")));
    }

    @Test public void minusTest() throws InterruptedException {

        testRule.launchActivity(null);

        httpChannel.subscribe(
                        result -> latch.countDown(),
                        err -> latch.countDown());

        buttonClick(R.id.calculator_button_1);

        buttonClick(R.id.calculator_button_minus);

        buttonClick(R.id.calculator_button_1);

        buttonClick(R.id.calculator_button_result);

        latch.await();

        onView(withId(R.id.calculator_edit_text)).check(matches(withText("0")));
    }

    @Test public void multiplyTest() throws InterruptedException {

        testRule.launchActivity(null);

        httpChannel.subscribe(
                        result -> latch.countDown(),
                        err -> latch.countDown());

        buttonClick(R.id.calculator_button_3);

        buttonClick(R.id.calculator_button_multiply);

        buttonClick(R.id.calculator_button_2);

        buttonClick(R.id.calculator_button_result);

        latch.await();

        onView(withId(R.id.calculator_edit_text)).check(matches(withText("9")));
    }

    @Test public void divideTest() throws InterruptedException {

        testRule.launchActivity(null);

        httpChannel.subscribe(
                        result -> latch.countDown(),
                        err -> latch.countDown());

        buttonClick(R.id.calculator_button_8);

        buttonClick(R.id.calculator_button_divide);

        buttonClick(R.id.calculator_button_2);

        buttonClick(R.id.calculator_button_result);

        latch.await();

        onView(withId(R.id.calculator_edit_text)).check(matches(withText("4")));
    }

    private void buttonClick(int id) {
        onView(withId(id)).perform(click());
    }
}
