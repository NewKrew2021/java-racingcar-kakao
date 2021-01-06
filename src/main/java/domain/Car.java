package domain;

public class Car {

    private final int STOP_VALUE = 3;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public boolean goOrStop(int i) {
        return i > STOP_VALUE;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(boolean isMove) {
        if(isMove){
            this.position++;
        }
    }

    @Override
    public String toString() {
        String pos = "";
        for(int i = 0; i < this.position; i++) {
            pos += "-";
        }
        return this.name + " : " + pos;
    }
}
