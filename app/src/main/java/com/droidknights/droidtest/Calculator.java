package com.droidknights.droidtest;

import io.reactivex.Single;
import retrofit2.Response;

public interface Calculator {
    Single<Response<String>> calculate(String expression);
}
