package racingcar;


import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class RacingGameApp {

    public static void main(String[] args) {

        String[] carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();

        RacingGame racingGame = new RacingGame(carNames, tryNo);

        while(!racingGame.isEnd()){
            racingGame.race();
        }

//        ArrayList<String> winners = racing.getWinners();
//        String result = String.join(", ", winners);
//        System.out.println(result + "가 최종 우승했습니다.");

    }
}
