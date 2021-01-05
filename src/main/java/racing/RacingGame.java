package racing;

import java.util.List;
import java.util.Scanner;

public class RacingGame {
    private static final Scanner sc = new Scanner(System.in);
    private Racing racing;

    public RacingGame(){

    }

    public void run() {
        this.startMessagePrint();
        String carNames = sc.next();
        this.tryMessagePrint();
        int progressNumber = sc.nextInt();
        this.racing = new Racing(progressNumber);
        racing.setCars(carNames);
        System.out.println("\n실행 결과");
        racing.repeatRacing();
        this.printWinner();
    }

    private void startMessagePrint() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    private void tryMessagePrint() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public void printWinner() {
        String s = "";
        List<Integer> resultPosition = racing.getPositions();
        for (int i = 0; i < resultPosition.size(); i++) {
            s += racing.isWinner(i);
        }
        s = s.substring(0, s.length() - 2);
        s += "가 최종 우승했습니다.";
        System.out.print(s);
    }
}
