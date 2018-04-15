package com.droidknights.droidtest;

import android.app.Application;

import com.droidknights.droidtest.step6.DaggerStep6Component;
import com.droidknights.droidtest.step6.Step6Component;
import com.droidknights.droidtest.step6.Step6Module;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;

import retrofit2.Response;

public class CalculatorApplication extends Application {

    private Step6Component step6Component;

    private Relay<Response<String>> httpChannel = PublishRelay.create();

    @Override
    public void onCreate() {
        super.onCreate();

        step6Component = DaggerStep6Component.builder()
                .step6Module(new Step6Module())
                .build();
    }

    public void setStep6Component(Step6Component step6Component) {
        this.step6Component = step6Component;
    }

    public Step6Component getStep6Component() {
        return step6Component;
    }

    public Relay<Response<String>> getHttpChannel() {
        return httpChannel;
    }
}
