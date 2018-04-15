package com.droidknights.droidtest.step6;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class Step6Module {
    @Singleton @Provides
    public Step6Calculator provideCalculator() {
        return new Step6CalculatorImpl();
    }
}
