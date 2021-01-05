/*
 * File     : Car.java
 * Date     : 2021. 01. 05
 */

package racing;

/*
 * Class    : Car
 * Version  : 1.1
 * author   : eli.nabro
 *
 * Car property class
 */
public class Car {

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(boolean isMoved) {
        if(isMoved){
            this.position++;
        }
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
