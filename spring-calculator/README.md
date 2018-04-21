# Spring Calculator
Step4 부터 사용되는 Calculator의 [Spring boot](https://projects.spring.io/spring-boot/) 버전입니다. `step3/Step3Calculator`, `step/Step3GeneralCalculator`를 spring-calcualtor의 `calculator package`에 복사 붙여넣기(Step3 코드와 완전히 같습니다.) 했습니다. 

CalculatorController.java 에서 Step3Calculator를 이용해 계산을 하고 그 결과를 전달합니다.


## [ngrok](https://ngrok.com/) 설치
`brew cask install ngrok`

## 실행방법
1. Terminal에서 `cd spring-calculator` 후 `./build_and_run.sh` 하거나 `./gradlew build && java -jar build/libs/calculator-1.0.0-SNAPSHOT.jar` 로 실행.
2. 프로젝트가 실행된 후 다른 Terminal을 열어서 `ngrok http 8080` 실행.
3. ngrok이 forwarding하는 주소 (아래 이미지에선 `https://35b1df83.ngrok.io`)를 `Android project`의 `app/build.gradle` 35번째 줄에 붙여넣음.
4. App Test 실행.

![ngrok 실행화면](https://github.com/moltak/droidnights2018/blob/master/img/ngrok.png?raw=true)