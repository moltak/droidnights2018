package com.droidknights.droidtest.step6;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = TestStep6Module.class)
interface TestStep6Component extends Step6Component {
    void inject(Step6ActivityTest step6ActivityTest);
}
