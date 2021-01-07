package racingcar.util;

public class CheckMovableByRandomNumberForTest extends CheckMovableByRandomNumber {

    private static final int UNMOVABLE_NUMBER = 3;

    @Override
    protected int makeRandomValue() {
        return UNMOVABLE_NUMBER;
    }

}
