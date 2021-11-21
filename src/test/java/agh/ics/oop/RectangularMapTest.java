package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangularMapTest {
    @Test
    public void placeTest () {
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };

        for (Vector2d p: positions) {
            Assertions.assertTrue(map.place(new Animal(map, p)));
        }

        for (Vector2d p: positions) {
            Assertions.assertFalse(map.place(new Animal(map, p)));
        }
    }

    @Test
    public void isOccupiedTest () {
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };

        for (Vector2d p: positions) {
            Assertions.assertFalse(map.isOccupied(p));
            map.place(new Animal(map, p));
            Assertions.assertTrue(map.isOccupied(p));
        }
    }


    @Test
    public void canMoveTest () {
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };

        for (Vector2d p: positions) {
            map.place(new Animal(map, p));
            Assertions.assertFalse(map.canMoveTo(p));
        }

        Assertions.assertFalse(map.canMoveTo(new Vector2d(11, 5)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(10, 6)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(-1, 0)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(0, -1)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(0, 0)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(4, 4)));
    }

    @Test
    public void objectAtTest () {
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };

        for (Vector2d p: positions) {
            Animal guineaPig = new Animal(map, p);
            map.place(guineaPig);
            Assertions.assertEquals(map.objectAt(p), guineaPig);
        }

        Assertions.assertEquals(map.objectAt(new Vector2d(0, 0)), null);
    }
}
