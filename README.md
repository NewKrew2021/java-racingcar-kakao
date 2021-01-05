## 기능 요구사항(원본)
주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## danny
- [ ] (Car) 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한.
    - [ ] 이름 설정
    - [ ] 차량 정보 출력
- [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    - [ ] n번 전진 후진
- [ ] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
    - [ ] , 기준 이름 구분
    - [ ] 5자 이하 검
- [ ] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.사
    - [ ] 숫자 입력 받아 이동
- [ ] 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
    - [ ] random 출력
    - [ ] 경계값으로 이동
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.


## corby

### 도메인
- [x] 이름을 받아서 자동차를 만들 수 있다.
    - [x] 빈 문자열은 허용하지 않는다.
    - [x] 5자 이하의 문자열만 허용한다.
- [x] 자동차를 조건에 따라서 전진시킨다.(0에서 9 사이에서 random 값을 구한 후, random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 전진하지 않는다)
- [x] 시도 횟수만큼 자동차들의 전진을 시도한다.
- [x] 자동차들 중 가장 앞서 있는 자동차들을 찾는다.

### 입출력
- [x] 쉼표로 구분된 이름들을 입력 받는다.
- [ ] 시도할 횟수를 입력받는다.
    - [ ] 정수 이외의 문자열은 허용하지 않는다.
- [ ] 각 라운드의 실행결과를 출력한다.
- [ ] 최종 우승자를 출력한다.


## joy

주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [ ] 한대의 자동차를 전진


각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.


자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.


사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [ ] 시도 횟수 입력 받기
- [ ] 사용자 입력 유효성 체크

전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- [ ] 0에서 9 사이에서 random 값을 구하기
- [ ] 한대의 자동차 전진하기
- [ ] 전진여부 확인

자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- [ ] 리스트에서 가장 큰 값을 리턴
- [ ] 자동차의 전진 거리를 리턴


--
실행 결과

위 요구사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

pobi : -----
crong : ----
honux : -----

pobi, honux가 최종 우승했습니다.
---