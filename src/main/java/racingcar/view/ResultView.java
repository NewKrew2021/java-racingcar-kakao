package racingcar.view;

public class ResultView {
    private static final String ROUND_START = "실행 결과";
    private static final String GAME_RESULT = "가 최종 우승했습니다";

    public static void printRoundStart() {
        System.out.println("\n" + ROUND_START);
    }

    public static void print(String str) {
        System.out.println(str);
    }

    public static void printWinner(String winner) {
        System.out.println(winner + GAME_RESULT);
    }

}
