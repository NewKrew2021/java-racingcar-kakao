package racingcar.domain;

public class CarName {

    private final String name;
    private static final int MAX_NAME_LENGTH = 5;

    public CarName(String name) {
        if(nameIsBlank(name)){
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다");
        }

        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("자동차 이름이 5글자를 초과 할 수 없습니다.");
        }
        this.name = name;
    }

    public boolean nameIsBlank(String name){
        return name == null || name.isEmpty();
    }

    public String getName(){
        return this.name;
    }
}
