package carRace.dtos;

import java.util.Objects;

public class CarDTO {
    private final String name;
    private final int location;

    public CarDTO(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarDTO)) return false;
        CarDTO carDTO = (CarDTO) o;
        return location == carDTO.location && Objects.equals(name, carDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}
