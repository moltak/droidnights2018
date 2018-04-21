# Android test
## [@Droidknights 2018](https://droidknights.github.io/2018/)
### 발표 자료 [Google Presentation](https://docs.google.com/presentation/d/1i7DvR3Xddmh5cD59PpbFyO_RZb5wOwLp5pJ-jx4oa5U/edit?usp=sharing)


### 프로젝트 설명
이 프로젝트는 Android 개발에서 테스트를 작성하는 방법과 TDD를 하는 방법에 대해 설명하고 있습니다. 바로 TDD(일반적으로는 Unit test를 이용하는)를 하는 것은 어렵고 수련이 필요합니다. 또한, 연동되어야 하는 모듈들 (Database, API server 등)에 따라 작성하기 어려운 상황이 매우 많습니다. 그래서 Acceptance(`인수 테스트` 혹은 `UI 테스트` 라고 부릅니다.) 테스트를 먼저 작성한 후 Unit 테스트를 하는 방법에 대해 설명합니다. Acceptance 테스트를 먼저 작성 한 후 Activity의 동작 로직(Business Logic. 이 프로젝트에서는 Calculate 함수)들을 넣은 후 동작 로직을 다른 객체(interface와 class)로 분류하여 Unit 테스트를 작성하면 보다 원활히 TDD를 할 수 있습니다.

이 프로젝트는 총 Step1~Step6 구성 되어있으며 각 Step은 `UnitTest`, `AcceptanceTest`, `Activity`를 포함하고 있습니다. 

Unit 테스트는 [app/src/test](https://github.com/moltak/droidnights2018/tree/master/app/src/test/java/com/droidknights/droidtest), Acceptance 테스트는 [app/src/androidTest](https://github.com/moltak/droidnights2018/tree/master/app/src/androidTest/java/com/droidknights/droidtest)에서 확인 할 수 있습니다.

### 필요사항
모든 테스트를 통과시키기 위해 `spring-calculator`를 실행해야 합니다. Step4 부터는 `Calculator`를 API server로 분리하였습니다. 왜냐하면 안드로이드를 개발할 때 API server와 통신을 하는 경우가 매우 많습니다. 그 경우를 가정하여 Step4에서부터는 `Calculator`를 API server로 분리한 후 테스트를 작성하고 있습니다.

[spring-calculator/README.md](https://github.com/moltak/droidnights2018/blob/master/spring-calculator/README.md)를 읽어주세요.

### Reference
[Android Testing patterns](https://www.youtube.com/watch?v=W8LJjfkTKik)

[DaggerTest](https://github.com/tomoima525/DaggerTestExample)

[Espresso](https://developer.android.com/training/testing/espresso/index.html)