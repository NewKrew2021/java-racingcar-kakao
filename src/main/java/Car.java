public class Car {
    private String name;

    public Car(String name) {
        if(name == null){
            throw new IllegalArgumentException();
        }
        if(name.length() == 0){
            throw new IllegalArgumentException();
        }
        if(name.length() >= 6) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
