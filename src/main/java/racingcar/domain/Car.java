package racingcar.domain;

import racingcar.util.StringUtil;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int THRESHOLD = 4;
    private final String name;
    private int location;

    public Car(String name){
        validate(name);

        this.name = name;
    }

    public Car(String name, int location){
        this(name);
        this.location = location;
    }

    private void validate(String name) {
        if(StringUtil.isNullOrEmpty(name)){
            throw new IllegalArgumentException("한대 이상의 자동차를 입력해주세요.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("차 이름은 5자 이하여야 합니다.");
        }
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
