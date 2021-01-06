package racingcar.view;

import racingcar.utils.InputValidChecker;

import java.util.Scanner;

public class InputScanner {
    private static final Scanner scan = new Scanner(System.in);

    private InputScanner() {
        throw new IllegalStateException("Utility Class");
    }

    public static String scanName() {
        InputPrinter.inputNamePrint();
        String name = scan.nextLine();
        if(!InputValidChecker.isValidNames(name)) {
            InputPrinter.illegalNamePrint();
            System.exit(0);
        }
        return name;
    }

    public static int scanRound() {
        InputPrinter.inputRoundPrint();
        String round = scan.nextLine();
        if(!InputValidChecker.isValidRounds(round)) {
            InputPrinter.illegalRoundPrint();
            System.exit(0);
        }
        return Integer.parseInt(round);
    }
}
