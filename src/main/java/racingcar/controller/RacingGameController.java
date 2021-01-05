package racingcar.controller;

import racingcar.view.Circuit;
import racingcar.domain.RacingGame;

import java.util.Scanner;

public class RacingGameController {
    private RacingGame racingGame;
    private int time;
    private Circuit circuit;

    public void run() {
        circuit = new Circuit();
        opening();
        start();
        end();
    }

    public void opening() {
        Scanner sc = new Scanner(System.in);
        circuit.printRequestName();
        racingGame = new RacingGame(sc.nextLine());
        circuit.printRequestTime();
        time = sc.nextInt();
    }

    public void start() {
        for (int i = 0; i < time; i++) {
            racingGame.race();
            circuit.printRaceStatus(racingGame.getRaceStatus());
        }
    }

    public void end() {
        circuit.printEnd(racingGame.getRaceWinners());
        circuit.printRaceStatus(racingGame.getRaceStatus());
    }
}
