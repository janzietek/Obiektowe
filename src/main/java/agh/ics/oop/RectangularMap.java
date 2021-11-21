package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap implements IWorldMap {
    public int widht;
    public int height;

    public RectangularMap (int widht, int height) {
        this.widht = widht;
        this.height = height;
    }

    @Override
    protected Vector2d getLowerLeft() {
        return new Vector2d(0, 0);
    }

    @Override
    protected Vector2d getUpperRight() {
        return new Vector2d(widht, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (super.canMoveTo(position) && position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(widht, height))) return true;

        return false;
    }

}
