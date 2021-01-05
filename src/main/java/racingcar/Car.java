package racingcar;

public class Car {
    private int position = 0;
    private final int RANDOM_SCOPE = 10;
    public int makeRandomNumber(){
        return ((int)(Math.random() * 10000) % RANDOM_SCOPE);
    }

    public int getDistance(int distance){
        if(distance<4){
            return 0;
        }
        return 1;
    }

    public int updateCarPosition(int distance){
        position += distance;
        return position;
    }

}
