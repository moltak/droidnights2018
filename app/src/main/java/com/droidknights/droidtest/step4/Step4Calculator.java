package com.droidknights.droidtest.step4;

import io.reactivex.Single;
import retrofit2.Response;

public interface Step4Calculator {
    Single<Response<String>> calculate(String expression);
}
