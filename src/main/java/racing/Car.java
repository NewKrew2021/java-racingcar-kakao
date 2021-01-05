/*
 * File     : Car.java
 * Date     : 2021. 01. 05
 */

package racing;

/*
 * Class    : Car
 * Version  : 1.0
 * author   : eli.nabro
 *
 * Car property class
 */
public class Car {

    private final int STOP_VALUE = 3;
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean decideGoOrStop(int i) {
        return i > STOP_VALUE;
    }

    public void move(boolean isMoved) {
        if(isMoved){
            this.position++;
        }
    }

    @Override
    public String toString() {
        String posBar = "";
        for(int i = 0; i < this.position; i++) {
            posBar += "-";
        }
        return this.name + " : " + posBar;
    }
}
