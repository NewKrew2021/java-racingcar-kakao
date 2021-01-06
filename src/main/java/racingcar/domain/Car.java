package racingcar.domain;

import java.util.Objects;

public class Car {

    private final CarPosition position;
    private final CarName name;

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

    public void move(RandomNumber randomNo){
        if(randomNo.isMovableRandomNumber()){
            this.position.forward();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
