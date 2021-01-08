package carracing;

import carracing.service.CarRacingProgram;
import carracing.view.RacingInfoScanner;

public class MainApplication {

    public static void main(String[] args) {
        String carNames = RacingInfoScanner.insertCarNames();
        int tryCount = RacingInfoScanner.insertRaceTryCount();

        CarRacingProgram racingProgram = new CarRacingProgram(carNames, tryCount);

        racingProgram.race();
    }
}
