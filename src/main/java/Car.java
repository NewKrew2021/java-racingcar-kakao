public class Car {
    public static final int MOVE_THRESHOLD = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String STRING_CAR_NAME_ERROR = "자동차 이름 길이는 1이상 5이하 입니다";

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name == null || name.length() == 0 || name.length() > MAX_NAME_LENGTH) {
            throw new InvalidCarNameException(STRING_CAR_NAME_ERROR);
        }
    }

    public void moveOrNot(int condition) {
        if (condition >= MOVE_THRESHOLD) {
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

    public static class InvalidCarNameException extends RuntimeException {
        public InvalidCarNameException(String e) {
            super(e);
        }
    }
}
