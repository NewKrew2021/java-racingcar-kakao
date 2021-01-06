package racingcar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Racing racing = new Racing(sc.next());

        System.out.println("시도할 회수는 몇회인가요?");
        int time = sc.nextInt();

        RacingManager manager = new RacingManager(time, racing);
        manager.race();
    }
}
