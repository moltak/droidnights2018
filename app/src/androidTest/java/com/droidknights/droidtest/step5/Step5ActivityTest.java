package com.droidknights.droidtest.step5;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.droidknights.droidtest.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.reactivex.observers.TestObserver;
import retrofit2.Response;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class Step5ActivityTest {
    @Rule public ActivityTestRule<Step5Activity> testRule = new ActivityTestRule(Step5Activity.class);

    @Test public void plusTest() {

        TestObserver<Response<String>> testObserver = TestObserver.create();

        ((Step5ViewModel) testRule.getActivity().getViewModel())
                .getHttpStream()
                .subscribe(testObserver);

        buttonClick(R.id.calculator_button_1);

        buttonClick(R.id.calculator_button_plus);

        buttonClick(R.id.calculator_button_1);

        buttonClick(R.id.calculator_button_result);

        testObserver.awaitCount(1);

        onView(withId(R.id.calculator_edit_text)).check(matches(withText("2")));
    }

    @Test public void minusTest() {

        TestObserver<Response<String>> testObserver = TestObserver.create();

        ((Step5ViewModel) testRule.getActivity().getViewModel())
                .getHttpStream()
                .subscribe(testObserver);

        buttonClick(R.id.calculator_button_1);

        buttonClick(R.id.calculator_button_minus);

        buttonClick(R.id.calculator_button_1);

        buttonClick(R.id.calculator_button_result);

        testObserver.awaitCount(1);

        onView(withId(R.id.calculator_edit_text)).check(matches(withText("0")));
    }

    @Test public void multiplyTest() {

        TestObserver<Response<String>> testObserver = TestObserver.create();

        ((Step5ViewModel) testRule.getActivity().getViewModel())
                .getHttpStream()
                .subscribe(testObserver);

        buttonClick(R.id.calculator_button_3);

        buttonClick(R.id.calculator_button_multiply);

        buttonClick(R.id.calculator_button_2);

        buttonClick(R.id.calculator_button_result);

        testObserver.awaitCount(1);

        onView(withId(R.id.calculator_edit_text)).check(matches(withText("9")));
    }

    @Test public void divideTest() {

        TestObserver<Response<String>> testObserver = TestObserver.create();

        ((Step5ViewModel) testRule.getActivity().getViewModel())
                .getHttpStream()
                .subscribe(testObserver);

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
