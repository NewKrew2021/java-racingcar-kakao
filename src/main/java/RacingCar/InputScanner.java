package RacingCar;

import java.util.Scanner;

public class InputScanner {
    private Scanner scan;

    public InputScanner() {
        scan = new Scanner(System.in);
    }

    public String scanName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String name = scan.nextLine();
        return name;
    }

    public int scanRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        int round = scan.nextInt();
        return round;
    }
}
