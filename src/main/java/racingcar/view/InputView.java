package racingcar.view;

import java.util.Scanner;

public class InputView {

    public static String enterCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int enterRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
