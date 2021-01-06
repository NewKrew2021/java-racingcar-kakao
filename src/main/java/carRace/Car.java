package carRace;

public class Car implements Comparable<Car>{

    private static final int LOWER_LIMIT_OF_MOVE = 4;

    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car otherCar) {
        return otherCar.location - location;
    }

    public void judgeAndGo(int randomNo) {
        if (judge(randomNo)) {
            go();
        }
    }

    private boolean judge(int randomNo) {
        return LOWER_LIMIT_OF_MOVE <= randomNo;
    }

    private void go() {
        location++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(name + " : ");
        for(int i = 0; i < location; i++){
            sb.append('-');
        }
        return sb.toString();
    }
}