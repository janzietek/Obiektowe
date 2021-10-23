package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString() {
        switch (this) {
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
            case WEST:
                return "ZACHOD";
            case EAST:
                return "WSCHOD";
            default:
                return "Nie ma takiej wartosci";
        }
    }

    public MapDirection next() {
        switch (this) {
            case NORTH: return MapDirection.EAST;
            case SOUTH: return MapDirection.WEST;
            case WEST: return MapDirection.NORTH;
            default: return MapDirection.SOUTH;
        }
    }

    public MapDirection previous() {
        switch (this) {
            case NORTH: return MapDirection.WEST;
            case SOUTH: return MapDirection.EAST;
            case WEST: return MapDirection.SOUTH;
            default: return MapDirection.NORTH;
        }
    }

    public Vector2d toUnitVector() {
        switch (this) {
            case NORTH: return new Vector2d(1, 0);
            case SOUTH: return new Vector2d(-1, 0);
            case WEST: return new Vector2d(0, -1);
            case EAST: return new Vector2d(0, 1);
            default: return new Vector2d(0, 0);
        }
    }

}

