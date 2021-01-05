package racingcar.view;

import racingcar.domain.CarInfo;

import java.util.List;

public class Circuit {

    public void printRequestName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printRequestTime() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printRaceStatus(List<CarInfo> carInfos) {
        for (CarInfo carInfo : carInfos) {
            System.out.println(carInfo);
        }
        System.out.println();
    }

    public void printEnd(List<String> winnerNames) {
        System.out.println(String.join(",", winnerNames) + "가 최종 우승했습니다.");
    }
}
