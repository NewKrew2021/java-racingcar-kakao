package racingCar;

import java.util.List;

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

    public void roundResultView(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public void gameResultView(List<Car> winners) {
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(convertCarName(winners, i));
        }
        System.out.println("가 최종 우승했습니다.");
    }

    public String convertCarName(List<Car> winners, int index) {
        String name = winners.get(index).getName();
        if (index == winners.size() - 1) {
            return name;
        }
        return name + ", ";
    }

}
