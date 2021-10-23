package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {
    @Test
    public void equalsTest () {
        Assertions.assertTrue(new Vector2d(10, 10).equals(new Vector2d(10, 10)));
        Assertions.assertFalse(new Vector2d(10, 10).equals(new Vector2d(10, 11)));
    }

    @Test
    public void toStringTest () {
        Assertions.assertEquals("(10,10)",new Vector2d(10, 10).toString());
    }

    @Test
    public void precedesTest () {
        Assertions.assertTrue(new Vector2d(10, 10).precedes(new Vector2d(101, 101)));
        Assertions.assertFalse(new Vector2d(10, 10).precedes(new Vector2d(9, 11)));
    }

    @Test
    public void followsTest () {
        Assertions.assertTrue(new Vector2d(100, 100).follows(new Vector2d(11, 11)));
        Assertions.assertFalse(new Vector2d(10, 10).follows(new Vector2d(9, 11)));
    }

    @Test
    public void upperRightTest () {
        Assertions.assertTrue(new Vector2d(11, 11).equals(new Vector2d(9, 11).upperRight(new Vector2d(11, 9))));
    }

    @Test
    public void lowerLeftTest () {
        Assertions.assertTrue(new Vector2d(9, 9).equals((new Vector2d(9, 11)).lowerLeft(new Vector2d(11, 9))));
    }

    @Test
    public void addTest () {
        Assertions.assertTrue(new Vector2d(20, 20).equals((new Vector2d(9, 11)).add(new Vector2d(11, 9))));
    }

    @Test
    public void sebstractTest () {
        Assertions.assertTrue(new Vector2d(-2, 2).equals((new Vector2d(9, 11)).substract(new Vector2d(11, 9))));
    }

    @Test
    public void oppositeTest () {
        Assertions.assertTrue(new Vector2d(-10, -10).equals(new Vector2d(10, 10).opposite()));
    }
}
