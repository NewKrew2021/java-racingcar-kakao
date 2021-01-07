package racingcar.view;

import racingcar.util.InputValidChecker;

import java.util.Scanner;

public class InputScanner {
    private static final Scanner scan = new Scanner(System.in);

    public InputScanner() {
        throw new IllegalStateException("Util Class.");
    }

    public static String inputName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String name = scan.nextLine();
        if(!InputValidChecker.validNames(name)) {
            exit();
        }
        return name;
    }

    public static int inputRound() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        String round = scan.nextLine();
        if(!InputValidChecker.validRound(round)) {
            exit();
        }
        return Integer.parseInt(round);
    }

    private static void exit() {
        System.out.println("잘못된 입력입니다.");
        System.exit(0);
    }
}
