public class Car {

    private final String name;

    public Car(String name){
        if(name == null ||
            name.length() > 5 ||
            name.equals(""))
            throw new IllegalArgumentException();
        this.name = name;
    }
}
