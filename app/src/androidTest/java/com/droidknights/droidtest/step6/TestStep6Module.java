package com.droidknights.droidtest.step6;

import com.droidknights.droidtest.Calculator;
import com.droidknights.droidtest.ViewModel;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;

import java.util.Arrays;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Single;
import retrofit2.Response;

@Module
public class TestStep6Module {
    @Provides @Singleton
    public Relay<Response<String>> provideHttpChannel() {
        return PublishRelay.create();
    }

    @Provides @Singleton
    public Calculator provideCalculator() {
        return expression -> {
            String symbol;

            if (expression.contains("+")) {
                symbol = "\\+";
            } else if (expression.contains("-")) {
                symbol = "-";
            } else if (expression.contains("*")) {
                symbol = "\\*";
            } else if (expression.contains("/")) {
                symbol = "/";
            } else {
                throw new RuntimeException("Not supported symbol");
            }

            List<String> arguments = Arrays.asList(expression.split(symbol));
            int result;

            switch (symbol) {
                case "\\+":
                    result = Integer.valueOf(arguments.get(0)) + Integer.valueOf(arguments.get(1));
                    break;
                case "-":
                    result = Integer.valueOf(arguments.get(0)) - Integer.valueOf(arguments.get(1));
                    break;
                case "\\*":
                    result = (int) Math.pow(Integer.valueOf(arguments.get(0)), Integer.valueOf(arguments.get(1)));
                    break;
                case "/":
                    result = Integer.valueOf(arguments.get(0)) / Integer.valueOf(arguments.get(1));
                    break;
                default: throw new RuntimeException("Not supported symbol");
            }

            return Single.just(Response.success(String.valueOf(result)));
        };
    }

    @Provides @Singleton
    public ViewModel provideViewModel(Calculator calculator, Relay<Response<String>> httpChannel) {
        return new Step6ViewModel(calculator, httpChannel);
    }
}
