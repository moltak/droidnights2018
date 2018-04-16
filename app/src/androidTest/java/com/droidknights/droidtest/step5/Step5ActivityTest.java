package com.droidknights.droidtest.step5;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.droidknights.droidtest.CalculatorApplication;
import com.droidknights.droidtest.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class Step5ActivityTest {
    @Rule public ActivityTestRule<Step5Activity> testRule = new ActivityTestRule(Step5Activity.class);

    private CountDownLatch latch;

    @Before public void setUp() {
        latch = new CountDownLatch(1);
    }

    @Test public void plusTest() throws InterruptedException {

        ((Step5ViewModel) testRule.getActivity().getViewModel())
                .getHttpChannel()
                .subscribe(
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

        ((Step5ViewModel) testRule.getActivity().getViewModel())
                .getHttpChannel()
                .subscribe(
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

        ((Step5ViewModel) testRule.getActivity().getViewModel())
                .getHttpChannel()
                .subscribe(
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

        ((Step5ViewModel) testRule.getActivity().getViewModel())
                .getHttpChannel()
                .subscribe(
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
