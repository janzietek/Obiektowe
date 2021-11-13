package agh.ics.oop;

public class Animal {
    private Vector2d position;
    private MapDirection orientation = MapDirection.NORTH;
    private IWorldMap map;

    public Animal (IWorldMap map, Vector2d initialPosition) {
        this.position = initialPosition;
        this.map = map;
    }


    public String toString() {
        return switch (this.orientation) {
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
        };
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
                if (map.canMoveTo(this.orientation.toUnitVector().add(this.position)))
                    this.position = this.orientation.toUnitVector().add(this.position);
                break;
            case BACKWARD:
                if (map.canMoveTo(this.orientation.toUnitVector().opposite().add(this.position)))
                    this.position = this.orientation.toUnitVector().opposite().add(this.position);
                break;
        }
    }

    public boolean isAt (Vector2d position) {
        if (position.equals(this.position)) return true;
        else return false;
    }
}
