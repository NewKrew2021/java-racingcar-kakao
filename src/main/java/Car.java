public class Car {
    private String name;
    private int position;

    public Car(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (name.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (name.length() >= 6) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.position = 0;
    }

    public void moveOrNot(int condition) {
        if (condition >= 4) {
            moveForwardOne();
        }
    }

    private void moveForwardOne() {
        this.position++;
    }

    public boolean isForwardThan(Car car) {
        return this.position > car.position;
    }

    public boolean isAtSamePositionWith(Car car) {
        return this.position == car.position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
