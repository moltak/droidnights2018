package com.droidknights.droidtest.step5;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CalculatorService {
    @GET("/calculate/{expression}")
    Single<Response<String>> calculate(@Path("expression") String expression);
}