/*
 * File     : RacingGameUI.java
 * Date     : 2021. 01. 05
 */
package racing;

import java.util.List;
import java.util.Scanner;

/*
 * Class    : RacingGameUI
 * Version  : 1.0
 * author   : eli.nabro
 *
 * Racing game UI class
 */
public class RacingGameUI {

    RacingGameLogic racingGame;
    private static Scanner sc = new Scanner(System.in);
    private int numberOfTrials = 0;

    public RacingGameUI() {
        this.racingGame = new RacingGameLogic();
    }

    public void run() {
        this.setCarsName(this.inputCarNames());
        this.numberOfTrials = this.inputNumberOfTrials();
        this.playRacingGame(this.numberOfTrials);
        this.printWinner();
    }

    private String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return sc.next();
    }

    public void setCarsName(String carNames) {
        this.racingGame.setCars(carNames);
    }

    private int inputNumberOfTrials() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return sc.nextInt();
    }

    public List<Integer> playRacingGame(int numbers) {
        System.out.println("\n실행 결과");
        while (this.racingGame.checkPosition(numbers)) {
            this.racingGame.race();
            this.racePrint();
        }
        return this.racingGame.getCarsPosition();
    }

    private void printWinner() {
        String winners = this.racingGame.whoAreWinner(this.numberOfTrials);
        winners = winners.substring(0, winners.length() - 2) + "가 최종 우승했습니다.";
        System.out.print(winners);
    }

    private void racePrint() {
        for (Car car : this.racingGame.getCars()) {
            System.out.println(car);
        }
        System.out.println();
    }

}
