package carRace;

import java.util.List;
import java.util.Objects;

public class CarDTOs {
    private final List<CarDTO> dtos;

    public CarDTOs(List<CarDTO> dtos){
        this.dtos = dtos;
    }

    public int size(){
        return dtos.size();
    }

    public String getNameOf(int index){
        return dtos.get(index).name;
    }

    public int getLocationOf(int index){
        return dtos.get(index).location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarDTOs)) return false;
        CarDTOs carDTOs = (CarDTOs) o;
        return Objects.equals(dtos, carDTOs.dtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dtos);
    }
}
