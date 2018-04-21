package com.droidknights.droidtest.step6;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = Step6UnitTestModule.class)
public interface Step6UnitTestComponent extends Step6Component {
    void inject(Step6UnitTest test);
}
