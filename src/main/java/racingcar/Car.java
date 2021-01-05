package racingcar;

public class Car {
    private int position = 0;
    public int getDistance(int randomNumber){
        if(randomNumber<4){
            return 0;
        }
        return 1;
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
