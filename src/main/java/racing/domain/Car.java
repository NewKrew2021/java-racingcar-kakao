package racing.domain;

public class Car {

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        this.position++;
    }

    @Override
    public String toString() {
        StringBuilder posBar = new StringBuilder();

        for(int i = 0; i < this.position; i++) {
            posBar.append("-");
        }

        return this.name + " : " + posBar;
    }
}
