package carRace;

public class Car{
    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
    }

    public void judgeAndGo(int randomNo) {
        if (judge(randomNo)) {
            go();
        }
    }

    private boolean judge(int randomNo) {
        return 4 <= randomNo;
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