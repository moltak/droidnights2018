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

import javax.inject.Inject;

import io.reactivex.observers.TestObserver;
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

    @Inject Relay<Response<String>> httpStream;

    @Before public void setUp() {
        CalculatorApplication application = (CalculatorApplication) InstrumentationRegistry.getTargetContext().getApplicationContext();

        Step6TestComponent testComponent = DaggerStep6TestComponent.builder()
                .step6TestModule(new Step6TestModule())
                .build();
        application.setStep6Component(testComponent);
        testComponent.inject(this);
    }

    @Test public void plusTest() {

        testRule.launchActivity(null);

        TestObserver<Response<String>> testObserver = TestObserver.create();

        httpStream.subscribe(testObserver);

        buttonClick(R.id.calculator_button_1);

        buttonClick(R.id.calculator_button_plus);

        buttonClick(R.id.calculator_button_1);

        buttonClick(R.id.calculator_button_result);

        testObserver.awaitCount(1);

        onView(withId(R.id.calculator_edit_text)).check(matches(withText("2")));
    }

    @Test public void minusTest() {

        testRule.launchActivity(null);

        TestObserver<Response<String>> testObserver = TestObserver.create();

        httpStream.subscribe(testObserver);

        buttonClick(R.id.calculator_button_1);

        buttonClick(R.id.calculator_button_minus);

        buttonClick(R.id.calculator_button_1);

        buttonClick(R.id.calculator_button_result);

        testObserver.awaitCount(1);

        onView(withId(R.id.calculator_edit_text)).check(matches(withText("0")));
    }

    @Test public void multiplyTest() {

        testRule.launchActivity(null);

        TestObserver<Response<String>> testObserver = TestObserver.create();

        httpStream.subscribe(testObserver);

        buttonClick(R.id.calculator_button_3);

        buttonClick(R.id.calculator_button_multiply);

        buttonClick(R.id.calculator_button_2);

        buttonClick(R.id.calculator_button_result);

        testObserver.awaitCount(1);

        onView(withId(R.id.calculator_edit_text)).check(matches(withText("9")));
    }

    @Test public void divideTest() {

        testRule.launchActivity(null);

        TestObserver<Response<String>> testObserver = TestObserver.create();

        httpStream.subscribe(testObserver);

        buttonClick(R.id.calculator_button_8);

        buttonClick(R.id.calculator_button_divide);

        buttonClick(R.id.calculator_button_2);

        buttonClick(R.id.calculator_button_result);

        testObserver.awaitCount(1);

        onView(withId(R.id.calculator_edit_text)).check(matches(withText("4")));
    }

    private void buttonClick(int id) {
        onView(withId(id)).perform(click());
    }
}
