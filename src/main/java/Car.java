public class Car {
    private final String name;
    private static final int THRESHOLD = 3;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        if (isBlank(name) || name.length() > 5)
            throw new IllegalArgumentException("자동차 이름은 1글자 이상 5글자 이하로 해주세요!");

        this.name = name;
        this.position = position;
    }

    private boolean isBlank(String name) {
        return name == null || name.equals("") || name.equals(" ");
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void runWithCondition(int value) {
        if (value <= THRESHOLD) {
            return;
        }
        this.position++;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(name + " : ");
        for (int i = 0; i < this.position; ++i) {
            print.append("-");
        }
        return print.toString();
    }
}
