package racingcar.domain;

public class RandomNumberMoveStrategy implements MoveStrategy {
    private static final int MIN_MOVE_NUMBER = 4;
    
    @Override
    public boolean move() {
        return getRandomNumber() >= MIN_MOVE_NUMBER;
    }

    private int getRandomNumber() {
        return (int) (Math.random() * 10);
    }

}
