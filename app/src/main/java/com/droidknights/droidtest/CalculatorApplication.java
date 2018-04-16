package com.droidknights.droidtest;

import android.app.Application;

import com.droidknights.droidtest.step6.DaggerStep6Component;
import com.droidknights.droidtest.step6.Step6Component;
import com.droidknights.droidtest.step6.Step6Module;

public class CalculatorApplication extends Application {

    private Step6Component step6Component;

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
}
