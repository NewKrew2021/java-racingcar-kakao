public class Car {
    private String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name == null || name.length() == 0 || name.length() >= 6) {
            throw new IllegalArgumentException("이름은 null 이 아니고 길이가 1과 5 사이여야 합니다");
        }
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
