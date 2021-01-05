package racingcar;

import java.util.Scanner;

public class Input {
    private static final Scanner sc = new Scanner(System.in);

    public static String inputCarNames(){
        return sc.next();
    }

    public static int inputRound() {
        return sc.nextInt();
    }
}
