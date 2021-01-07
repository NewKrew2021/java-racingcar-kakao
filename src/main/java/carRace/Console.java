package carRace;

public class Console {
    public static void main(String[] args) {
        RacingGame game = new RacingGame(new RandomStrategy());
        game.run();
    }
}