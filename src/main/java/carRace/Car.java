package carRace;

public class Car implements Comparable<Car>{
    private final Name name;
    private int location;

    private Car(Name name) {
        this.name = name;
    }

    public static Car of(String name) {
        return new Car(new Name(name));
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public int compareTo(Car otherCar) {
        return location - otherCar.location;
    }

    public void go(MovingStrategy strategy) {
        if (strategy.movable()) {
            location++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(name.getName() + " : ");
        for (int i = 0; i < location; i++){
            sb.append('-');
        }
        return sb.toString();
    }
}
