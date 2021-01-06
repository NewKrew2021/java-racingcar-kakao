package racing;

import java.util.Scanner;

public class RacingGame {
    private static final Scanner sc = new Scanner(System.in);
    private Racing racing;

    public RacingGame(){

    }

    public void run() {
        this.beforeRace();
        this.repeatRace();
        this.afterRace();
    }

    public void beforeRace(){
        this.startMessagePrint();
        String carNames = sc.next();

        this.tryMessagePrint();
        int progressNumber = sc.nextInt();
        this.racing = new Racing(carNames, progressNumber);

        System.out.println("\n실행 결과");
    }

    public void repeatRace() {
        while (racing.isFinished()) {
            racing.race();
            System.out.println(racing.getRaceString());
            racing.decreaseProgressNumber();
        }
    }

    public void afterRace(){
        racing.setMaxPosition();
        this.printWinner();
    }

    private void startMessagePrint() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    private void tryMessagePrint() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public void printWinner() {
        System.out.print(racing.returnWinnerString());
    }
}
