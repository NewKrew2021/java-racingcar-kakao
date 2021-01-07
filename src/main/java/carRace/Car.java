package carRace;

public class Car implements Comparable<Car>{
    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
        StringBuilder sb = new StringBuilder(name + " : ");
        for (int i = 0; i < location; i++){
            sb.append('-');
        }
        return sb.toString();
    }
}