package com.droidknights.droidtest.step6;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = Step6Module.class)
public interface Step6Component {
    void inject(Step6Activity activity);
}
