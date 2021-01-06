package racingcar;

public class RandomMovingStrategy implements MovingStrategy {

    private final int RANDOM_SCOPE = 10;
    private final int MOVING_CRITERION = 3;

    public int makeRandomNumber(){
        return ((int)(Math.random() * RANDOM_SCOPE));
    }

    public boolean exceedMovingCriterion(int randomNumber){
        return randomNumber > MOVING_CRITERION;
    }

    @Override
    public boolean isMoving() {
        if(exceedMovingCriterion(makeRandomNumber())){
            return false;
        }
        return true;
    }
}
