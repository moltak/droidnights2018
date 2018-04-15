package com.droidknights.droidtest.step5;

import io.reactivex.Single;
import retrofit2.Response;

public interface Step5Calculator {
    Single<Response<String>> calculate(String expression);
}
