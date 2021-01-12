package racingcar.view;

import java.util.Scanner;

public class UserInputView {

    private static final String REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_ROUND = "시도할 회수는 몇회인가요?";

    public static String enterCarNames() {
        System.out.println(REQUEST_CAR_NAMES);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int enterRound() {
        System.out.println(REQUEST_ROUND);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
