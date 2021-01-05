package racingcar;

import java.util.List;

public class Car {
    private String name;
    private int loccation;

    public Car(String name){
        this.name = name;
        this.loccation = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getLoccation(){
        return this.loccation;
    }

    public void move(int condition){
        loccation += condition;
        printLocation();
    }

    private void printLocation(){
        Output.printRoundResult(name, loccation);
    }

}
