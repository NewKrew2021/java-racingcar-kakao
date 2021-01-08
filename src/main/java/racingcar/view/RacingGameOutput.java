package racingcar.view;

import racingcar.domain.RacingGame;

import java.util.ArrayList;
import java.util.List;

public class RacingGameOutput {

    public static void printStatus(String status) {
        System.out.println(status);
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println(result + "가 최종 우승했습니다.");
    }

}
