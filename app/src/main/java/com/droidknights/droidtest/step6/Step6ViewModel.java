package com.droidknights.droidtest.step6;

import com.droidknights.droidtest.Calculator;
import com.droidknights.droidtest.ViewModel;
import com.jakewharton.rxrelay2.Relay;

import retrofit2.Response;

public class Step6ViewModel implements ViewModel {

    private Relay<Response<String>> httpChannel;

    private Calculator calculator;

    public Step6ViewModel(Calculator calculator, Relay<Response<String>> httpChannel) {
        this.calculator = calculator;
        this.httpChannel = httpChannel;
    }

    @Override
    public void calculate(String expression) {
        calculator.calculate(expression)
                .subscribe(result -> httpChannel.accept(result), Throwable::printStackTrace);;
    }
}
