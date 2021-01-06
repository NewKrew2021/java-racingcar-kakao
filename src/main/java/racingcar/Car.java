package racingcar;

public class Car {

    private static final int RANDOM_SCOPE = 10;
    private static final int STOP_RANDOM_NUMBER =4;
    private static final int STOP_DISTANCE =0;
    private static final int MOVE_DISTANCE =1;
    private int position = 0;
    private String name = "";

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public int makeRandomNumber(){
        return (int)(Math.random() * RANDOM_SCOPE);
    }

    public int getDistance(int distance){
        if(distance<STOP_RANDOM_NUMBER){
            return STOP_DISTANCE;
        }
        return MOVE_DISTANCE;
    }

    public int updateCarPosition(int distance){
        position += distance;
        return position;
    }

    public int getPosition(){
        return position;
    }

    public String getName() {
        return name;
    }

    public String getNameIfMatched(int position) {
        if(this.position == position){
            return this.name;
        }
        return "";
    }
}
