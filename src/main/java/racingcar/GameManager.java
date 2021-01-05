package racingcar;

public class GameManager {
    private int round;

    public void start() {
        Cars newCars = new Cars();

        Output.printInputCars();
        newCars.setCars(Input.inputCarNames());

        Output.printInputRound();
        setRound(Input.inputRound());

    }

    public void setRound(int round) {
        this.round = round;
    }


}
