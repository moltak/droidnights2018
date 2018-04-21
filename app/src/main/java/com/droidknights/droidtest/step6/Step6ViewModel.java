package com.droidknights.droidtest.step6;

import com.droidknights.droidtest.Calculator;
import com.droidknights.droidtest.ViewModel;
import com.jakewharton.rxrelay2.Relay;

import retrofit2.Response;

public class Step6ViewModel implements ViewModel {

    private Relay<Response<String>> httpStream;

    private Calculator calculator;

    public Step6ViewModel(Calculator calculator, Relay<Response<String>> httpStream) {
        this.calculator = calculator;
        this.httpStream = httpStream;
    }

    @Override
    public void calculate(String expression) {
        calculator.calculate(expression)
                .subscribe(result -> httpStream.accept(result), Throwable::printStackTrace);;
    }
}
