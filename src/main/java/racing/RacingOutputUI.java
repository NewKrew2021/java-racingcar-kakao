/*
 * File     : RacingOutputUI.java
 * Date     : 2021. 01. 05
 */
package racing;

import java.util.List;

/*
 * Class    : RacingOutputUI
 * Version  : 1.0
 * author   : eli.nabro
 *
 * Racing game Output UI class
 */
public class RacingOutputUI {

    private static final String PRINT_CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String PRINT_TRIALS_QUESTION = "시도할 횟수는 몇회인가요?";
    private static final String PRINT_PRE_RACING_RESULT = "\n실행 결과";
    private static final String PRINT_RESULT_TAILS = "가 최종 우승했습니다.";

    public RacingOutputUI() {

    }

    public static void printCarNameQuestion() {
        System.out.println(PRINT_CAR_NAME_QUESTION);
    }

    public static void printTrialsQuestion() {
        System.out.println(PRINT_TRIALS_QUESTION);
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
