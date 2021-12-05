package agh.ics.oop;

import java.util.Random;
import java.lang.Math;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class GrassField extends AbstractWorldMap implements IWorldMap{
    private final Map<Vector2d, Grass> grasses = new LinkedHashMap<>();


    public GrassField (int n) {
        Random rand = new Random();
        while (grasses.size() < n) {
            Vector2d v = new Vector2d(rand.nextInt((int) Math.pow(10 * n, 0.5)), rand.nextInt((int) Math.pow(10 * n, 0.5)));
            if (grasses.get(v) == null) {
                Grass grass = new Grass(v);
                grasses.put(v, grass);
                super.mapBoundary.addObject(grass);
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
        int x = mapBoundary.objetsByX.first().getPosition().x;
        int y = mapBoundary.objetsByY.first().getPosition().y;

        Vector2d lowerLeft = new Vector2d(x, y);
        return new Vector2d(x, y);
    }

    @Override
    protected Vector2d getUpperRight() {
        int x = mapBoundary.objetsByX.last().getPosition().x;
        int y = mapBoundary.objetsByY.last().getPosition().y;

        Vector2d upperRight = new Vector2d(x, y);
        return upperRight;
    }
}
