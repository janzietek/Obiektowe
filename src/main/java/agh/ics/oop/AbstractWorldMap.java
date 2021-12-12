package agh.ics.oop;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d,Animal> animals = new LinkedHashMap<>();
    protected MapBoundary mapBoundary = new MapBoundary(this);


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        animals.put(newPosition, animals.get(oldPosition));
        mapBoundary.positionChanged(oldPosition, newPosition);
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
    public boolean place(Animal animal) throws IllegalArgumentException {
        if (isOccupied(animal.getPosition())) {
            Object object = objectAt(animal.getPosition());
            if (object.getClass() == animal.getClass()) {
                throw new IllegalArgumentException("Location " + animal.getPosition().toString() + " is already occupied");
            }
        }
        animals.put(animal.getPosition(), animal);
        mapBoundary.addObject(animal);
        animal.addObserver(this);
        return true;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        if (isOccupied(position)) {
            Object object = objectAt(position);
            Animal dog = animals.get(position);
            if (dog != null) {
                if (object.getClass() == dog.getClass())
                    return false;
            }
        }
        return true;
    }

    public abstract Vector2d getLowerLeft ();
    public abstract Vector2d getUpperRight ();

    public String toString () {
        return new MapVisualizer(this).draw(getLowerLeft(), getUpperRight());
    }
}
