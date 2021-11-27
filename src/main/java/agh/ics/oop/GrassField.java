package agh.ics.oop;

import java.util.Random;
import java.lang.Math;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class GrassField extends AbstractWorldMap implements IWorldMap{
    private Map<Vector2d, Grass> grasses = new LinkedHashMap<>();


    public GrassField (int n) {
        Random rand = new Random();
        while (grasses.size() < n) {
            Vector2d v = new Vector2d(rand.nextInt((int) Math.pow(10 * n, 0.5)), rand.nextInt((int) Math.pow(10 * n, 0.5)));
            if (grasses.get(v) == null) {
                grasses.put(v, new Grass(v));
            }
        }
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        Object o = grasses.get(position);
        if (o == null) {
            return super.isOccupied(position);
        }
        else {
            return true;
        }
    }


    @Override
    public Object objectAt(Vector2d position) {
        if (super.isOccupied(position))
            return super.objectAt(position);
        else {
            return grasses.get(position);
        }
    }

    @Override
    protected Vector2d getLowerLeft() {
        Vector2d fieldLowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);

        Set<Vector2d> animalPositions = animals.keySet();
        for (Vector2d aP: animalPositions) {
            fieldLowerLeft = fieldLowerLeft.lowerLeft(aP);
        }

        Set<Vector2d> grassesPositions = grasses.keySet();
        for (Vector2d gP: grassesPositions) {
            fieldLowerLeft = fieldLowerLeft.lowerLeft(gP);
        }
        return fieldLowerLeft;
    }

    @Override
    protected Vector2d getUpperRight() {
        Vector2d fieldUpperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

        Set<Vector2d> animalPositions = animals.keySet();
        for (Vector2d aP: animalPositions) {
            fieldUpperRight = fieldUpperRight.upperRight(aP);
        }

        Set<Vector2d> grassesPositions = grasses.keySet();
        for (Vector2d gP: grassesPositions) {
            fieldUpperRight = fieldUpperRight.upperRight(gP);
        }
        return fieldUpperRight;
    }
}
