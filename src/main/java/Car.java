public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public boolean isValid() {
        return name.length() <= 5;
    }

    public void go() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public void run(int value) {
        if (value <= 3) {
            return;
        }
        go();
    }
}
