# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항
- 자동차 이름을 입력받는다.
    - 이름은 5자 이하
    - 쉼표를 기준으로 split
- 이동 횟수를 입력받는다.
- 전진 여부를 구한다
    - 0~9 사이 랜덤값 구한 후, 랜덤값이 4 이상이면 전진, 3 이하면 멈춤
- 자동차가 전진한다.
- 자동차가 얼마나 전진했는지 출력한다.
- 우승자를 구한다.
    - 우승자는 한 명 이상일 수 있음.
  
## MVC
*Model*
> **Car** : 자동차에 대한 클래스. 자동차 정보와 자동차 한개의 움직임에 대한 메소드
> 
> **Cars** : 자동차집합에 대한 클래스. 요구되는 기능들은 대부분 자동차집합을 조작함으로써 일어난다.
> 
> **MovingStrategy** : 어떻게 움직일것인지를 추상화한 인터페이스
> 
> **RandomMovinStrategy** : MovingStrategy를 구현한 클래스. 랜덤하게 숫자를 생성하여 움직일지를 결정해준다.

*View*
> **Input** : 사용자 입력에 관한 메서드 제공
> 
> **Output** : 사용자 출력에 관한 메서드 제공

*Controller*
> **GameController** : view와 domain을 은닉하고 사용자에게 필요한 기능을 제공

*dtos*
> **CarDTO** : Car 클래스에 대한 정보를 전달하기 위한 dto
> 
> **CarDTOs** : CarDTO 리스트를 담고 있는 클래스

*utils*
> **StringUtil** : string관련 util

*Validations*
> **InputChecker** : 사용자 입력에 대해 유효성을 검사하는 역할을 담당
