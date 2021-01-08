package racingcar.domain;

public class Car {

    private final CarPosition position;
    private final CarName name;

    private static final int THRESHOLD_FORWARD_VALUE = 4;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position){
        this.name = new CarName(name);
        this.position = new CarPosition(position);
    }

    public String getName(){
        return this.name.getName();
    }

    public int getPosition(){
        return this.position.getPosition();
    }

    public void move(int value){
        if(isMovableValue(value)){
            this.position.forward();
        }
    }

    private boolean isMovableValue(int value) {
        return value >= THRESHOLD_FORWARD_VALUE;
    }
}
