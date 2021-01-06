package domain;

import racinggame.MoveStrategy;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name){
        if(name == null ||
                name.length() > 5 ||
                name.equals(""))
            throw new IllegalArgumentException();
        this.name = name;
    }

    public int getPosition(){
        return this.position;
    }

    public int move(MoveStrategy strategy){
        if(strategy.isMove())
            ++this.position;
        return this.position;
    }
}
