package racingcar;

public class Car {
    private static final int THRESHOLD = 4;
    private final String name;
    private int location;

    public Car(String name){
        this.name = name;
    }

    public Car(String name, int location){
        this(name);
        this.location = location;
    }

    public void move(int num){
        if(isMoveFoward(num))
            this.location++;
    }

    private boolean isMoveFoward(int number){
        if(number>=THRESHOLD)
            return true;
        return false;
    }

    public void printStatus(){
        String length = "";
        for(int i = 0; i < this.location; i++){
            length += "-";
        }
        System.out.println(this.name + " : " + length);
    }

    public String getName(){
        return this.name;
    }

    public boolean isMaxLocation(int maxLocation){
        return this.location == maxLocation;
    }

    public int maxLocation(int otherloc){
        if(this.location > otherloc)
            return this.location;
        return otherloc;
    }

    public boolean isLocated(int i) {
        if(i == this.location)
            return true;
        return false;
    }
}
