/*
 * File     : RacingInputUI.java
 * Date     : 2021. 01. 06
 */
package racing;

import java.util.Scanner;

/*
 * Class    : RacingInputUI
 * Version  : 1.0
 * author   : eli.nabro
 *
 * Racing Input UI class
 */
public class RacingInputUI {

    private static Scanner sc = new Scanner(System.in);

    public static void setInputStreamForTest(String in) {
        RacingInputUI.sc = new Scanner(in);
    }

    public static String inputCarNames() {
        return sc.next();
    }

    public static int inputNumberOfTrials() {
        return sc.nextInt();
    }

}
