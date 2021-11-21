package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.lang.Math;


public class GrassField extends AbstractWorldMap implements IWorldMap{
    private List<Grass> grasses = new LinkedList<>();


    public GrassField (int n) {
        Random rand = new Random();
        while (grasses.size() < n) {
            boolean test = true;
            Vector2d v = new Vector2d(rand.nextInt((int) Math.pow(10 * n, 0.5)), rand.nextInt((int) Math.pow(10 * n, 0.5)));
            for (Grass g: grasses) {
                if (g.getPosition().equals(v)) {
                    test = false;
                    break;
                }
            }
            if (test) {
                grasses.add(new Grass(v));
            }
        }
    }

    public List<Grass> getGrasses () {
        return grasses;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Grass g: grasses) {
            if (g.isAt(position)) return true;
        }
        return super.isOccupied(position);
    }


    @Override
    public Object objectAt(Vector2d position) {
        if (super.isOccupied(position))
            return super.objectAt(position);


        for (Grass g: grasses) {
            if (g.isAt(position)) return g;
        }
        return null;
    }

    @Override
    protected Vector2d getLowerLeft() {
        Vector2d fieldLowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);

        for (Animal a: animals) {
            fieldLowerLeft = fieldLowerLeft.lowerLeft(a.getPosition());
        }
        for (Grass g: grasses) {
            fieldLowerLeft = fieldLowerLeft.lowerLeft(g.getPosition());
        }
        return fieldLowerLeft;
    }

    @Override
    protected Vector2d getUpperRight() {
        Vector2d fieldUpperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

        for (Animal a: animals) {
            fieldUpperRight = fieldUpperRight.upperRight(a.getPosition());
        }
        for (Grass g: grasses) {
            fieldUpperRight = fieldUpperRight.upperRight(g.getPosition());
        }
        return fieldUpperRight;
    }
}
