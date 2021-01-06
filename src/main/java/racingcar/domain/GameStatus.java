package racingcar.domain;

public class GameStatus {

    private int gameCount;

    public GameStatus() {
        this(0);
    }

    public GameStatus(int gameCount) throws InvalidGameCountException{
        if(gameCount < 0) {
            throw new InvalidGameCountException("게임 횟수는 음수가 될 수 없습니다.");
        }
        this.gameCount = gameCount;
    }

    public boolean isGameEnd() {
        return gameCount == 0;
    }

    public void playGame() {
        if(gameCount > 0) {
            gameCount--;
        }
    }

    public int getGameCount() {
        return gameCount;
    }
}
