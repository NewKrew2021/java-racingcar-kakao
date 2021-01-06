package carracing.domain;

import carracing.view.CarRacingInfoPrint;

import java.util.Scanner;

public class RacingInfoScanner {
    private static Scanner sc = new Scanner(System.in);

    public static int insertRaceTryCount() {
        CarRacingInfoPrint.printRaceCountPhrase();
        int totalMoveCount = sc.nextInt();
        return totalMoveCount;
    }

    public static String insertCarNames(){
        CarRacingInfoPrint.printCarListInputPhrase();
        String carNames = sc.next();
        return carNames;
    }
}
