package racingcar;

public class Car {

    private int position;

    public Car(){
        this.position = 0;
    }

    public int getPosition(){
        return this.position;
    }
    
    public void goOrStop(int randomNumber) {
        if(randomNumber > 9 || randomNumber < 0) throw new RuntimeException();

        if (randomNumber < 4) {
            return;
        }
        this.position++;
    }
}
