package racegame;

import racegame.domain.Cars;
import racegame.domain.Winners;


public class GameView {

    public void gameStartMessageView() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void gameRoundMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void roundTitleView() {
        System.out.println("실행 결과");
    }

    public void roundResultView(Cars cars) {
        System.out.println(cars.getAllCarState());
    }

    public void gameResultView(Winners winners) {
        System.out.println(winners +  "가 최종 우승했습니다.");
    }

}
