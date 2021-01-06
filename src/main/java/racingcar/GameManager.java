package racingcar;

import java.util.OptionalInt;

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
        }
    }

    public void setRound(int round) {
        roundLengthCheck(round);
        this.round = round;
    }

    private void roundLengthCheck(int round) {
        if (round < 1){
            throw new RuntimeException("횟수를 1회 이상 입력해주세요.");
        }
    }


    public void result(){
        Output.printWinner(cars.checkWinner());
    }



}
