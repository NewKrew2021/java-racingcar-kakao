package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String inputCarNames(){
        return sc.next();
    }

    public static int inputRound() {
        return sc.nextInt();
    }
}
