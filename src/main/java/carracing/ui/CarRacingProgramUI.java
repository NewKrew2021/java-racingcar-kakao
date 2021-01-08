package carracing.ui;

import carracing.domain.Car;

import java.util.List;

public class CarRacingProgramUI {

    public static final String CAR_NAMES_INPUT_PHRASE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String RACE_COUNT_PHRASE = "시도할 회수는 몇회인가요?";
    public static final String RESULT_PHRASE = "실행 결과";
    public static final String WINNER_PHRASE = "가 최종 우승했습니다.";

    public static void printCarInputNamesPharse() {
        System.out.println(CAR_NAMES_INPUT_PHRASE);
    }

    public static void printRaceCountPhrase() {
        System.out.println(RACE_COUNT_PHRASE);
    }

    public static void printResultPharse() {
        System.out.println(RESULT_PHRASE);
    }

    public static void printWinnerPharse(List<String> winners) {
        StringBuilder winnerBuilder = new StringBuilder();

        for (int i = 0; i < winners.size() - 1; i++) {
            winnerBuilder.append(winners.get(i));
            winnerBuilder.append(", ");
        }
        winnerBuilder.append(winners.get(winners.size() - 1));

        winnerBuilder.append(WINNER_PHRASE);

        System.out.println(winnerBuilder.toString());
    }

    public static void printCarPosition(Car car) {
        System.out.println(car.getCarInfoString());
    }

    public static void printBlankLine() {
        System.out.println();
    }
}
