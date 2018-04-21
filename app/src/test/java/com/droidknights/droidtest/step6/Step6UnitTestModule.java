package com.droidknights.droidtest.step6;

import com.droidknights.droidtest.Calculator;
import com.droidknights.droidtest.ViewModel;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Single;
import retrofit2.Response;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Module
public class Step6UnitTestModule {
    @Provides @Singleton
    public Relay<Response<String>> provideHttpStream() {
        return PublishRelay.create();
    }

    @Provides @Singleton
    public Calculator provideCalculator() {
        Calculator calculator = mock(Calculator.class);

        when(calculator.calculate("1+1")).thenReturn(Single.just(Response.success("2")));
        when(calculator.calculate("1-1")).thenReturn(Single.just(Response.success("0")));
        when(calculator.calculate("3*2")).thenReturn(Single.just(Response.success("9")));
        when(calculator.calculate("8/2")).thenReturn(Single.just(Response.success("4")));

        return calculator;
    }

    @Provides @Singleton
    public ViewModel provideViewModel(Calculator calculator, Relay<Response<String>> httpStream) {
        return new Step6ViewModel(calculator, httpStream);
    }
}
