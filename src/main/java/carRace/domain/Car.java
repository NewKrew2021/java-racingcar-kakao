package carRace.domain;

import carRace.dtos.CarDTO;

public class Car{
    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int location) {
        this(name);
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public CarDTO getDTO() {
        return new CarDTO(name, location);
    }

    public void judgeAndGo(MovingStrategy strategy) {
        if (strategy.movable()) {
            location++;
        }
    }
}