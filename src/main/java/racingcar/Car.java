package racingcar;

public class Car {
    private String name;
    private int location;

    public Car(String name){
        this.name = name;
        this.location = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getLocation(){
        return this.location;
    }

    public void move(int condition){
        location += condition;
    }

    public void printCarLocation(){
        Output.printRoundResult(name, location);
    }

    public String findWinner(int winnerLocation){
        if(location == winnerLocation){
            return name + " ";
        }
        return "";
    }

}
