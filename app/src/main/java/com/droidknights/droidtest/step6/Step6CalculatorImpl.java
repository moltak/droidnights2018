package com.droidknights.droidtest.step6;

import com.droidknights.droidtest.step5.CalculatorService;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Step6CalculatorImpl implements Step6Calculator {
    @Override
    public Single<Response<String>> calculate(String expression) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://c17433f7.ngrok.io/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CalculatorService service = retrofit.create(CalculatorService.class);
        return service.calculate(expression);
    }
}