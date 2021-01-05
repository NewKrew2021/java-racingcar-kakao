package racingcar;

public class GameManager {
    private int round;
    private Cars cars = new Cars();


    public void start() {
        Output.printInputCars();
        cars.setCars(Input.inputCarNames());

        Output.printInputRound();
        setRound(Input.inputRound());
        startRound();
    }

    private void startRound() {
        for (int i = 0; i < round; i++) {
            cars.move();
        }
    }

    public void setRound(int round) {
        this.round = round;
    }


    public void winner(){

    }


}
