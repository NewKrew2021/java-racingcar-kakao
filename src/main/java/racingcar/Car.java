package racingcar;

public class Car {
    private String name;
    private int location;

    public void setName(String name){
        this.name = name;
    }

    public void move(){
        if(isMoveFoward(getRandomNo()))
            this.location++;
    }

    private boolean isMoveFoward(int number){
        if(number>=4)
            return true;
        return false;
    }
    private int getRandomNo(){
        return (int) (Math.random()*10);
    }
}
