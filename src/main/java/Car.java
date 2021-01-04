public class Car {
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public boolean isValid() {
        return name.length() <= 5;
    }
}
