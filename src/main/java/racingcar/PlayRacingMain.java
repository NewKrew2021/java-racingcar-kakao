package racingcar;

public class PlayRacingMain {

    private static final UserInput printer = new UserInput();

    public static void main(String[] args){
        String names = printer.enterCarNames();
        int round = printer.enterRound();
        Racing rc = new Racing(names, round);

        System.out.println("실행 결과");
        rc.race();
    }
}
