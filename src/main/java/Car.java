public class Car {
    private final String name;
    private int position;

    public Car(String name, int position){
        this.name = name;
        this.position = position;
    }

    public boolean isEqualPosition(Car car){
        return car.position == position;
    }
}
