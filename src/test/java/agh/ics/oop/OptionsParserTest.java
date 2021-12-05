package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionsParserTest {
    @Test
    public void praseTest () {
        String[] commands = {"r", "f", "right", "b", "l", "forward"};
        MoveDirection[] expectedCommands = {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.RIGHT,MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.FORWARD};
        Assertions.assertArrayEquals(OptionsParser.parse(commands), expectedCommands);

    }

    @Test
    public void praseExepctionTest () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String[] commands = {"r", "f", "righto", "buuu", "l", "forward"};
            OptionsParser.parse(commands);
        });
    }
}
