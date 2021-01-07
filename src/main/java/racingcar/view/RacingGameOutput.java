package racingcar.view;

import racingcar.domain.RacingGame;

import java.util.ArrayList;

public class RacingGameOutput {

    public static void printStatus(RacingGame racing) {
        String status = racing.getCarsStatus();
        System.out.println(status);
        System.out.println();
    }

    public static void printWinner(RacingGame racing) {
        ArrayList<String> winners = racing.getWinners();
        String result = String.join(", ", winners);
        System.out.println(result + "가 최종 우승했습니다.");
    }

}
