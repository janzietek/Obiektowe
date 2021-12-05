package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;


public class GrassFieldTest {
    @Test
    public void placeTest () {
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };

        for (Vector2d p: positions) {
            Assertions.assertTrue(map.place(new Animal(map, p)));
        }
    }

    @Test
    public void placeExepctionTest () {
        Throwable exepction = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IWorldMap map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,2) };
            for (Vector2d p: positions) {
                map.place(new Animal(map, p));
            }
        });

        Assertions.assertEquals(exepction.getMessage(), "Location (2,2) is already occupied");
    }

    @Test
    public void isOccupiedTest () {
        GrassField map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };

        for (Vector2d p: positions) {
            map.place(new Animal(map, p));
            Assertions.assertTrue(map.isOccupied(p));
        }
    }


    @Test
    public void canMoveTest () {
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };

        for (Vector2d p: positions) {
            map.place(new Animal(map, p));
            Assertions.assertFalse(map.canMoveTo(p));
        }
    }

    @Test
    public void objectAtTest () {
        GrassField map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        for (Vector2d p: positions) {
            Animal guineaPig = new Animal(map, p);
            map.place(guineaPig);
            Assertions.assertEquals(map.objectAt(p), guineaPig);
        }
    }
}
