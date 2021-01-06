package carracing.domain;

import java.util.Scanner;

public class RacingInfoScanner {
    private static Scanner sc = new Scanner(System.in);

    public static int insertRaceTryCount() {
        int totalMoveCount = sc.nextInt();
        return totalMoveCount;
    }

    public static String insertCarNames(){
        String carNames = sc.next();
        return carNames;
    }
}
