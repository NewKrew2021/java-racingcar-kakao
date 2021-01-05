package domain;

public class Car {
//    public final static Comparator<Car> comparotr = new Comparator<Car>() {
//        @Override
//        public int compare(Car o1, Car o2) {
//            return Integer.compare(o1.getPosition(), o2.getPosition());
//        }
//    };

    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (isMovable(number)) {
            ++position;
        }
    }

    private boolean isMovable(int number) {
        return number > RacingGame.MOVE_THRESHOLD;
    }
}