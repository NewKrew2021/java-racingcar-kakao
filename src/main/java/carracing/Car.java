package carracing;

public class Car {
    private String name;
    private int position;
    private final String POSITION_MARKER = "-";

    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public void go(){
        this.position++;
    }

    public void show(){
        StringBuilder positionBuilder = new StringBuilder();

        positionBuilder.append(name + " : ");

        for (int i = 0; i < this.position; i++) {
            positionBuilder.append(POSITION_MARKER);
        }

        System.out.println(positionBuilder.toString());
    }
}
