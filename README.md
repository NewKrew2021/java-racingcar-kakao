# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

##Calculator 

* 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
   if (text == null) {}
   if (text.isEmpty()) {}
* 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
   int number = Integer.parseInt(text);
* 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
   String[] numbers = text.split(",");
   // 앞 단계의 구분자가 없는 경우도 split()을 활용해 구현할 수 있는지 검토해 본다.
* 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
   String[] tokens= text.split(",|:");
* “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
   // java.util.regex 패키지의 Matcher, Pattern import
   Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
   if (m.find()) {
   String customDelimiter = m.group(1);
   String[] tokens= m.group(2).split(customDelimiter);
   // 덧셈 구현
   }
* 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
   구글에서 “junit5 expected exception”으로 검색해 해결책을 찾는다.

## CarRace
### 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

### 기능 목록
- 자동차 전진
- 자동차 정지
- 자동차 생성자
- 자동차를 전진할때 이름 출력
- 사용자 이름을 `spilt(",")` 파싱, 다섯 글자 제한
- RacingCarGame 초기화 함수 (문자열을 입력받고 그에맞게 자동차를 생성)
- 이동 횟수 입력
- 입력한 횟수 만큼 `racingGame()` 반복
- 전진 조건을 랜덤으로 구하기
- 게임 종료시 조건 확인

### 구현할 클래스
- Car.java
- RacingCarGame.java
- 쉼표기준으로 구분하고 이름 검사하는 util 클래


#### 질문할 목록
- git commit 메시지 컨벤션에서 ($)가 의미하는것이 무엇인가? 어떻게 써야하는가
- `car.java` 안에 있는 public static final 변수 합당한가?
- RacingCarGame.java 안에 있는 token 변수를 빼야하는지?? 아니면 그냥 `,` 상태로 두어도 괜찮은지?
