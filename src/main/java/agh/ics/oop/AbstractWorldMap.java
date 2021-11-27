package agh.ics.oop;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d,Animal> animals = new LinkedHashMap<>();


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        animals.put(newPosition, animals.get(oldPosition));
        animals.remove(oldPosition);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        Object o = animals.get(position);
        if (o == null) {
            return false;
        }
        else {
            return true;
        }
    }


    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.getPosition())) {
            Object object = objectAt(animal.getPosition());
            if (object.getClass() == animal.getClass())
                return false;
        }
        animals.put(animal.getPosition(), animal);
        animal.addObserver(this);
        return true;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        if (isOccupied(position)) {
            Object object = objectAt(position);
            Animal dog = animals.get(position);
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
