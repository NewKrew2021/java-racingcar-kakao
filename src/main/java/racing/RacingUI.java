/*
 * File     : RacingUI.java
 * Date     : 2021. 01. 05
 */
package racing;

import java.util.List;
import java.util.Scanner;

/*
 * Class    : RacingUI
 * Version  : 1.2
 * author   : eli.nabro
 *
 * Racing game UI class
 */
public class RacingUI {

    private static final String PRINT_CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String PRINT_TRIALS_QUESTION = "시도할 횟수는 몇회인가요?";
    private static final String PRINT_PRE_RACING_RESULT = "\n실행 결과";
    private static final String PRINT_RESULT_TAILS = "가 최종 우승했습니다.";

    private RacingGameLogic racingGame;
    private static Scanner sc;
    private int numberOfTrials = 0;

    public RacingUI() {
        RacingUI.sc = new Scanner(System.in);
    }

    public RacingUI(String in) {
        RacingUI.sc = new Scanner(in);
    }

    public void run() {
        this.printCarNameQuestion();
        this.setCarsName(this.inputCarNames());
        this.printTrialsQuestion();
        this.numberOfTrials = this.inputNumberOfTrials();
        this.playRacingGame(this.numberOfTrials);
        this.printWinner();
    }

    private void printCarNameQuestion() {
        System.out.println(PRINT_CAR_NAME_QUESTION);
    }

    private String inputCarNames() {
        return sc.next();
    }

    public void setCarsName(String carNames) {
        this.racingGame = new RacingGameLogic(carNames);
    }

    private void printTrialsQuestion() {
        System.out.println(PRINT_TRIALS_QUESTION);
    }

    private int inputNumberOfTrials() {
        return sc.nextInt();
    }

    public List<Integer> playRacingGame(int numbers) {
        System.out.println(PRINT_PRE_RACING_RESULT);
        while (this.racingGame.checkPosition(numbers)) {
            this.racingGame.race();
            this.racePrint();
        }
        return this.racingGame.getCarsPosition();
    }

    private void printWinner() {
        String winners = this.racingGame.whoAreWinner(this.numberOfTrials);
        winners = winners.substring(0, winners.length() - 2) + PRINT_RESULT_TAILS;
        System.out.print(winners);
    }

    private void racePrint() {
        for (Car car : this.racingGame.getCars()) {
            System.out.println(car);
        }
        System.out.println();
    }

}
