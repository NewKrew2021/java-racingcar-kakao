package racing.view;

import racing.domain.Car;

import java.util.List;

public class RacingOutputUI {

    private static final String PRINT_PRE_RACING_RESULT = "\n실행 결과";
    private static final String PRINT_RESULT_TAILS = "가 최종 우승했습니다.";

    public RacingOutputUI() {

    }

    public static void printPreRacingResult() {
        System.out.println(PRINT_PRE_RACING_RESULT);
    }

    public static void printWinner(String winners) {
        System.out.print(winners.substring(0, winners.length() - 2) + PRINT_RESULT_TAILS);
    }

    public static void racePrint(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

}
