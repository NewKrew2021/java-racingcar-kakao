package carracing.domain;

public class Car {
    private String name;
    private int position;
    private final int CAR_NAME_LENGTH_THRESHOLD = 5;

    public Car(String name){
        this(name, 0);
    }

    public Car(String name, int position){
        if(checkCarNameLength(name) && isNotBlank(name)){
            this.name = name;
            this.position = position;
        }
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

    private boolean checkCarNameLength(String carName){
        if(carName.length() <= CAR_NAME_LENGTH_THRESHOLD)
            return true;

        throw new RuntimeException("이름의 길이가 " + CAR_NAME_LENGTH_THRESHOLD + "를 넘습니다.");
    }

    private boolean isNotBlank(String carName){
        if(!carName.isEmpty() && carName != null)
            return true;

        throw new RuntimeException("비어있거나 null인 문자열입니다.");
    }
}
