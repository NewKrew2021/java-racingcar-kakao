package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.Circuit;

public class RacingGameController {
    private static Circuit circuit = new Circuit();
    private static RacingGame racingGame;

    public static void main(String[] args) {
        String carNames = circuit.getCarNames();
        racingGame = new RacingGame(carNames);

        int iterationNumber = circuit.getIterNo();
        for (int i = 0; i < iterationNumber; i++) {
            racingGame.racing();
            circuit.printStatus(racingGame.getStatus());
        }

        circuit.printResult(racingGame);
    }
}
