package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    Comparator<IMapElement> comByX = (A, B) -> {
        if (A.getPosition().x > B.getPosition().x)
            return 1;
        else if (A.getPosition().x < B.getPosition().x)
            return -1;
        else {
            if (A.getPosition().y > B.getPosition().y)
                return 1;
            else if (A.getPosition().y < B.getPosition().y)
                return -1;
            else {
                if (A.getClass() == Animal.class)
                    return -1;
                else
                    return 1;
            }
        }
    };

    Comparator<IMapElement> comByY = (A, B) -> {
        if (A.getPosition().y > B.getPosition().y)
            return 1;
        else if (A.getPosition().y < B.getPosition().y)
            return -1;
        else {
            if (A.getPosition().x > B.getPosition().x)
                return 1;
            else if (A.getPosition().x < B.getPosition().x)
                return -1;
            else {
                if (A.getClass() == Animal.class)
                    return -1;
                else
                    return 1;
            }
        }
    };

    IWorldMap map;
    protected SortedSet<IMapElement> objetsByX = new TreeSet<>(comByX);
    protected SortedSet<IMapElement> objetsByY = new TreeSet<>(comByY);

    public MapBoundary (IWorldMap map) {
        this.map = map;
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        objetsByX.remove((IMapElement) map.objectAt(oldPosition));
        objetsByY.remove((IMapElement) map.objectAt(oldPosition));
        objetsByX.add((IMapElement) map.objectAt(newPosition));
        objetsByY.add((IMapElement) map.objectAt(newPosition));

    }

    public void addObject (IMapElement A) {
        objetsByX.add(A);
        objetsByY.add(A);
    }
}
