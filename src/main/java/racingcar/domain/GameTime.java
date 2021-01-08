package racingcar.domain;

import java.util.Objects;

public class GameTime {
    private static final int MIN_VALUE = 0;
    private static final int END_VALUE = 0;
    private int gameTime;

    public GameTime(int gameTime) {
        checkValid(gameTime);
        this.gameTime = gameTime;
    }

    public boolean isEnd() {
        return gameTime == END_VALUE;
    }

    public void process() {
        gameTime--;
    }

    private void checkValid(int gameTime) {
        if (gameTime < MIN_VALUE) {
            throw new IllegalArgumentException("음수 값이 될 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameTime gameTime1 = (GameTime) o;
        return gameTime == gameTime1.gameTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameTime);
    }
}
