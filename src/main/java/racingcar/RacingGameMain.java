package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.RacingGameInput;
import racingcar.view.RacingGameOutput;

import java.util.ArrayList;
import java.util.List;

public class RacingGameMain {
    private static RacingGame racing;

    public static void main(String[] args) {
        RacingGameInput gameInput = new RacingGameInput();
        String[] names = gameInput.carNameInput();
        RacingGame racing = new RacingGame(names);
        int count = gameInput.countInput();

        System.out.println("\n실행 결과");
        String status;
        for(int i=0; i< count; i++){
            status = racing.race();
            RacingGameOutput.printStatus(status);
        }
        List<String> winners = racing.getWinners();
        RacingGameOutput.printWinner(winners);
    }
}
