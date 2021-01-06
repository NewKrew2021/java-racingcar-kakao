package carRace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarDTOsTest {

    CarDTOs dtos;

    @BeforeEach
    public void setUp() {
        dtos = new CarDTOs(
                Arrays.asList(
                        new CarDTO("test1", 6),
                        new CarDTO("test2", 2),
                        new CarDTO("test3", 4),
                        new CarDTO("test4", 5),
                        new CarDTO("test5", 10),
                        new CarDTO("test6", 10)
                )
        );
    }

    @Test
    public void sizeTest(){
        assertThat(dtos.size()).isEqualTo(6);
    }

    @Test
    public void getNameOfTest(){
        assertThat(dtos.getNameOf(3)).isEqualTo("test4");
    }

    @Test
    public void getLocationOfTest(){
        assertThat(dtos.getNameOf(5)).isEqualTo("test6");
    }
}
