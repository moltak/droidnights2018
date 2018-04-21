package com.droidknights.droidtest.step6;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = Step6TestModule.class)
interface Step6TestComponent extends Step6Component {
    void inject(Step6ActivityTest step6ActivityTest);
}
