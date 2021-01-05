package racingcar;

public class Car {
    private String name;
    int location;

    public void setName(String name){
        this.name = name;
    }

    public void move(int num){
        if(isMoveFoward(num))
            this.location++;
    }

    private boolean isMoveFoward(int number){
        if(number>=4)
            return true;
        return false;
    }
}
