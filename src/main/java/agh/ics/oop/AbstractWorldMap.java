package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new LinkedList<>();


    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal a: animals) {
            if (a.isAt(position)) return true;
        }
        return false;
    }


    @Override
    public Object objectAt(Vector2d position) {
        for (Animal a: animals) {
            if (a.isAt(position)) return a;
        }
        return null;
    }

    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.getPosition())) {
            Object object = objectAt(animal.getPosition());
            if (object.getClass() == animal.getClass())
                return false;
        }
        animals.add(animal);
        return true;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        if (isOccupied(position)) {
            Object object = objectAt(position);
            Animal dog = new Animal(this, position);
            if (object.getClass() == dog.getClass())
                return false;
        }
        return true;
    }

    protected abstract Vector2d getLowerLeft ();
    protected abstract Vector2d getUpperRight ();

    public String toString () {
        return new MapVisualizer(this).draw(getLowerLeft(), getUpperRight());
    }
}
