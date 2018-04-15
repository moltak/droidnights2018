package com.droidknights.droidtest.step6;

import io.reactivex.Single;
import retrofit2.Response;

public interface Step6Calculator {
    Single<Response<String>> calculate(String expression);
}
