package Car;

import Utils.NumberUtil;

public class CarManager {
    private static final int MOVE_CONDITION_THRESHOLD = 4;
    private static final int RANDON_BOUND = 10;

    public boolean movable() {
        if (NumberUtil.generateRandomNumber(RANDON_BOUND) >= MOVE_CONDITION_THRESHOLD)
            return true;

        return false;
    }
}
