package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimulationEngineTest {
    @Test
    public void runTest () {
        String[] commands = {"f", "b", "r", "l", "f", "b",};
        MoveDirection[] directions = new OptionsParser().parse(commands);
        IWorldMap map = new RectangularMap(2, 2);
        Vector2d[] positions = { new Vector2d(1,1), new Vector2d(0, 1) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Assertions.assertTrue(map.isOccupied(new Vector2d(2, 2)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(1, 0)));
    }
}
