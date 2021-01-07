package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.domain.RoundResult;

public class PrintRacing {

    public static void printResultSentence() {
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(RoundResult roundResult) {
        roundResult.getResult().forEach(PrintRacing::printDist);
        System.out.println();
    }

    public static void printDist(String name, int dist) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append(" : ");
        for (int i = 0; i < dist; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString());
    }

    public static void printWinners(String[] winners) {
        System.out.print(String.join(", ", winners));
        System.out.println("가 최종 우승했습니다.");
    }
}
