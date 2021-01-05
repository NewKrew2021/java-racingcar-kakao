package racingcar;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RacingCarGameApp {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        RacingCarGame game = new RacingCarGame();

        try {
            String text = getText();
            int racingNum = getRacingNum();
            game.start(text, racingNum);

        } catch (InputMismatchException e) {
            System.out.println("시도할 횟수는 숫자만 입력 가능합니다.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        printWinners(game);
    }

    private static int getRacingNum() {
        System.out.println("시도할 회수는 몇회인가?");

        return sc.nextInt();
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static String getText() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String text = sc.nextLine();

        if (isBlank(text)) {
            throw new RuntimeException("이름이 공백입니다.");
        }

        return text;
    }

    private static void printWinners(RacingCarGame game) {
        StringBuilder winnerString = new StringBuilder();

        List<String> winners = game.getWinners();
        for (String winner : winners) {
            winnerString.append(winner).append(",");
        }
        System.out.print(winnerString.substring(0,winnerString.length() - 1));
        System.out.println("가 최종 우승했습니다.");
    }

}
