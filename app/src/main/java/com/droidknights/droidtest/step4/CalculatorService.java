package com.droidknights.droidtest.step4;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CalculatorService {
    @GET("/calculate/")
    Single<Response<String>> calculate(@Query("expression") String expression);
}