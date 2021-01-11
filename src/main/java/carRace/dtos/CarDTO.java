package carRace.dtos;

import java.util.Objects;

public class CarDTO {
    public final String name;
    public final int location;

    public CarDTO(String name, int location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDTO carDTO = (CarDTO) o;
        return location == carDTO.location && Objects.equals(name, carDTO.name);
    }
}
