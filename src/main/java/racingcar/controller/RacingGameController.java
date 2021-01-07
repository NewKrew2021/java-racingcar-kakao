package racingcar.controller;

import racingcar.domain.RapTime;
import racingcar.view.RaceReporter;
import racingcar.domain.RacingGame;

import java.util.Scanner;

public class RacingGameController {
    private RacingGame racingGame;
    private RapTime rapTime;
    private RaceReporter raceReporter;
    private Scanner sc;
    public RacingGameController(){
        raceReporter = new RaceReporter();
        sc = new Scanner(System.in);
    }

    public void opening() {
        raceReporter.printRequestName();
        racingGame = new RacingGame(sc.nextLine());
        raceReporter.printRequestTime();
        rapTime = new RapTime(sc.nextInt());
    }

    public void start() {
        while (!rapTime.isEnd()) {
            racingGame.race(rapTime);
            raceReporter.printRaceStatus(racingGame.getRaceStatus());
        }
    }

    public void end() {
        raceReporter.printEnd(racingGame.getRaceWinners());
    }
}
