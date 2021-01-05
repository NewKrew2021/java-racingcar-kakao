package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingCarGameApp {
    public static void main(String[] args) {
        RacingCarGame game = new RacingCarGame();
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String text = sc.nextLine();
        int racingNum = sc.nextInt();

        game.start(text, racingNum);
    }
}
