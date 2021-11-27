package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    boolean precedes(Vector2d other) {
        if (this.x <= other.x && this.y <= other.y) return true;
        else return false;
    }


    boolean follows(Vector2d other) {
        if (this.x >= other.x && this.y >= other.y) return true;
        else return false;
    }

    Vector2d upperRight(Vector2d other) {
        int X, Y;

        if (this.x > other.x) X = this.x;
        else X = other.x;

        if (this.y > other.y) Y = this.y;
        else Y = other.y;

        return new Vector2d(X, Y);
    }

    Vector2d lowerLeft(Vector2d other) {
        int X, Y;

        if (this.x < other.x) X = this.x;
        else X = other.x;

        if (this.y < other.y) Y = this.y;
        else Y = other.y;

        return new Vector2d(X, Y);
    }

    Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }


    Vector2d substract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return x == vector2d.x && y == vector2d.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    Vector2d opposite () {
        return new Vector2d((-1) * this.x, (-1) * this.y);
    }
}
