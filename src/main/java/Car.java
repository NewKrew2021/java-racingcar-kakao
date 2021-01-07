import java.util.Random;

public class Car implements Comparable<Car> {
    private static final int MOVE_THRESHOLD = 4;
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;
    private final Random rand;

    public Car(String name) {
        if (name.length() > MAX_NAME_LENGTH) throw new IllegalArgumentException();
        this.name = name;
        this.position = 0;
        rand = new Random();
    }

    public Car(String name, int position) {
        if (name.length() > MAX_NAME_LENGTH) throw new IllegalArgumentException();
        this.name = name;
        this.position = position;
        rand = new Random();
    }

    public String getName() {
        return name;
    }

    public boolean isEqualPosition(Car car) {
        return car.position == position;
    }

    public void move() {
        move(generateRandomNumber());
    }

    public void move(int randomNumber) {
        if (randomNumber > MOVE_THRESHOLD) position++;
    }

    private int generateRandomNumber() {
        return rand.nextInt(10);
    }

    public void printName() {
        IOUtils.print(name);
    }

    public void printNameAndPosition() {
        IOUtils.println(name + " : " + "-".repeat(position));
    }

    @Override
    public int compareTo(Car o) {
        if (o.position > position) return 1;
        if (o.position < position) return -1;
        return 0;
    }
}
