package domain;

public class CarFixture {
    private static final Engine ALWAYS_MOVE_ENGINE = new AlwaysMoveEngine();

    public static Car createCar(String name, int position) {
        Car car = new Car(ALWAYS_MOVE_ENGINE, name);
        for (int i = 0; i < position; i++) {
            car.tryMoving();
        }

        return car;
    }
}
