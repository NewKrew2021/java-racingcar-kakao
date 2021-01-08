package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.game.CarGame;

import java.util.ArrayList;
import java.util.Collections;


public class CarOutput {

    public static void printRoundStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRoundResult(CarGame game) {
        for (Car car : game.getCars()) {
            System.out.println(car.getName() + " : " + String.join("", Collections.nCopies(car.getPosition(), "-")));
        }
        System.out.println();
    }

    public static void printWinnerCar(ArrayList<String> winners) {
        System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
    }

}
