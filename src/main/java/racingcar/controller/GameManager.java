package racingcar;

import racingcar.exception.InvalidRoundLengthException;

public class GameManager {
    private int round;
    private Cars cars = new Cars();


    public void start() {
        Output.printInputCars();
        cars.setCars(Input.inputCarNames());

        Output.printInputRound();
        setRound(Input.inputRound());

        startRound();
        result();
    }

    private void startRound() {
        for (int i = 0; i < round; i++) {
            cars.move();
            printRoundResult();
        }
    }



    private void printRoundResult(){
        cars.printRoundResult();
        Output.printNewLine();
    }
    public void setRound(int round) {
        roundLengthCheck(round);
        this.round = round;
    }

    private void roundLengthCheck(int round) {
        if (round < 1){
            throw new InvalidRoundLengthException("횟수를 1회 이상 입력해주세요.");
        }
    }


    public void result(){
        Output.printWinner(cars.getWinner());
    }





}
