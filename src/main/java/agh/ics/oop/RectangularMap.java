package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    public int widht;
    public int height;
    public List<Animal> animals = new LinkedList<>();

    public RectangularMap (int widht, int height) {
        this.widht = widht;
        this.height = height;
    }

    public String toString () {
        return new MapVisualizer(this).draw(new Vector2d(0, 0), new Vector2d(this.widht, this.height));
    }


    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.getPosition())) return false;

        animals.add(animal);
        return true;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (isOccupied(position)) return false;

        if (position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(widht, height))) return true;

        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getPosition().equals(position))
                return true;
        }

        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).isAt(position))
                return animals.get(i);
        }
        return null;
    }
}
