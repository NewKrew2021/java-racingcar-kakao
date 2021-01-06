package racingcar.domain;


public class Car {
    private Name name;
    private Location location = new Location();

    public Car(String name){
        this.name = new Name(name);
    }

    public String getName(){
        return this.name.toString();
    }

    public int getLocation(){
        return this.location.getLocation();
    }

    public void move(int condition){
        this.location.move(condition);
    }

    public String getCarLocations() {
        return name.toString() + " : " + "-".repeat(location.getLocation());
    }

    public String findWinner(int winnerLocation){
        if(location.getLocation() == winnerLocation){
            return name + " ";
        }
        return "";
    }

}
