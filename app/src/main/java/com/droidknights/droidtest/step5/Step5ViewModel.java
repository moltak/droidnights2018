package com.droidknights.droidtest.step5;

import com.droidknights.droidtest.Calculator;
import com.droidknights.droidtest.ViewModel;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;

import retrofit2.Response;

public class Step5ViewModel implements ViewModel {

    private Relay<Response<String>> httpChannel = PublishRelay.create();

    private Calculator calculator = new Step5CalculatorImpl();

    @Override
    public void calculate(String expression) {
        calculator.calculate(expression)
                .subscribe(result -> httpChannel.accept(result), Throwable::printStackTrace);;
    }

    public Relay<Response<String>> getHttpChannel() {
        return httpChannel;
    }
}
