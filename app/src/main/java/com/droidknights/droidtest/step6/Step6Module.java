package com.droidknights.droidtest.step6;

import com.droidknights.droidtest.Calculator;
import com.droidknights.droidtest.ViewModel;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Response;

@Module
public class Step6Module {

    @Provides @Singleton
    public Relay<Response<String>> provideHttpStream() {
        return PublishRelay.create();
    }

    @Provides @Singleton
    public Calculator provideCalculator() {
        return new Step6CalculatorImpl();
    }

    @Provides @Singleton
    public ViewModel provideViewModel(Calculator calculator, Relay<Response<String>> httpStream) {
        return new Step6ViewModel(calculator, httpStream);
    }
}
