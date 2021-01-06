package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String getNames() {
        return sc.next();
    }

    public static int getTime() {
        return sc.nextInt();
    }
}
