package racingcar.util;

import java.util.Scanner;

public class InputScanner {
    private static final Scanner scan = new Scanner(System.in);

    public static String inputName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String name = scan.nextLine();
        if(!InputValidChecker.isValidNames(name)) {
            System.out.println("잘못된 입력입니다.");
            System.exit(0);
        }
        return name;
    }

    public static int inputRound() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        String round = scan.nextLine();
        if(!InputValidChecker.isValidRounds(round)) {
            System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
            System.exit(0);
        }
        return Integer.parseInt(round);
    }
}
