package carracing.domain;

public class Car {
    private String name;
    private int position;

    public Car(String name){
        this(name, 0);
    }

    public Car(String name, int position){
        this.name = name;
        this.position = position;
    }

    public int go(){
        return this.position += 1;
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }
}
