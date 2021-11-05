package agh.ics.oop;

public class Animal {
    private Vector2d position = new Vector2d (2, 2);
    private MapDirection orientation = MapDirection.NORTH;


    public String toString() {
        return position.toString() + " zwrócony na " + orientation.toString();
    }

    private Vector2d legalMove (boolean isBackward) {
        Vector2d movement = this.orientation.toUnitVector();
        if (isBackward) {
            movement = movement.opposite();
        }
        Vector2d newPosition = this.position.add(movement);

        if (newPosition.precedes(new Vector2d(4, 4)) && newPosition.follows(new Vector2d(0, 0))) {
            return newPosition;
        }
        else
            return this.position;
    }

    public MapDirection getOrientation () {
        return this.orientation;
    }


    public Vector2d getPosition () {
        return this.position;
    }

    public void move (MoveDirection direction) {
        switch (direction) {
            case LEFT:
                this.orientation = orientation.previous();
                break;
            case RIGHT:
                this.orientation = orientation.next();
                break;
            case FORWARD:
                this.position = legalMove(false);
                break;
            case BACKWARD:
                this.position = legalMove(true);
                break;
        }
    }
}
