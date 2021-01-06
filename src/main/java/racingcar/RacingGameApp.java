package racingcar;

public class RacingGameApp {
    private static RacingGame racing;

    public static void main(String[] args) {
        RacingGameInput gameInput = new RacingGameInput();
        String[] names = gameInput.carNameInput();
        RacingGame racing = new RacingGame(names);
        int count = gameInput.countInput();

        System.out.println("\n실행 결과");
        for(int i=0; i< count; i++){
            racing.moveCars();
            RacingGameOutput.printStatus(racing);
        }
        RacingGameOutput.printWinner(racing);
    }
}
