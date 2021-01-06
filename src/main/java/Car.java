public class Car {

    private final String name;
    private int position = 0;

    public Car(String name){
        if(name == null ||
            name.length() > 5 ||
            name.equals(""))
            throw new IllegalArgumentException();
        this.name = name;
    }

    public int move(){
        return ++this.position;
    }
}
