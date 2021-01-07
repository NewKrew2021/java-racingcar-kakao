package racingcar.view;

import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class GameView {

    public void roundResult(Cars cars) {

        System.out.println(cars.toString());
    }

    public void printStartPhrase() {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void gameResult(List<String> winners) {

        System.out.println(convertCarName(winners) + "가 최종 우승했습니다.");
    }

    public String convertCarName(List<String> winners) {

        return winners.stream()
                .collect(Collectors.joining(", "));
    }

    public void printAskRoundPhrase() {

        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printErrorInputPhrase() {

        System.out.println("잘못된 입력입니다. 다시 입력해주세요!");
    }


}
