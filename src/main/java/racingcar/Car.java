package racingcar;

public class Car {
    String name;
    int location;

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
        if(number>=4)
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
}
