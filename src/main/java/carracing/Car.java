package carracing;

public class Car {
    private String name;
    private int position;
    private final String POSITION_MARKER = "-";

    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public int go(){
        return this.position += 1;
    }

    public String getCarInfoString(){
        StringBuilder positionBuilder = new StringBuilder();

        positionBuilder.append(this.name);
        positionBuilder.append(" : ");

        for (int i = 0; i < this.position; i++) {
            positionBuilder.append(POSITION_MARKER);
        }

        return positionBuilder.toString();
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }
}
