package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String INPUT_ROUND = "시도할 횟수는 몇회인가요?";

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAME);
        return sc.next();
    }

    public static int inputRound() {
        System.out.println(INPUT_ROUND);
        return sc.nextInt();
    }

}
