package racingcar.view;

import racingcar.domain.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameView {
    private static final Scanner sc = new Scanner(System.in);

    public static int getTryNo() {
        int tryNo = 0;

        try {
            System.out.println("시도할 회수는 몇회인가?");
            tryNo = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("시도할 횟수는 숫자만 입력해주세요.");
        }

        return tryNo;
    }

    public static String getText() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        return sc.nextLine();
    }

    public static void printRacing(RacingCarGame game) {

        System.out.println(game.getCars());
    }

    public static void printWinners(RacingCarGame game) {
        StringBuilder winnerString = new StringBuilder();

        Winners winners = game.findWinners();
        winnerString.append(winners);
        winnerString.append("가 최종 우승했습니다.");

        System.out.println(winnerString);
    }
}
