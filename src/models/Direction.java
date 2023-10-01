package models;

public enum Direction {
    HORIZONTAL_RIGHT(new Coordinate(1, 0)),
    HORIZONTAL_LEFT(new Coordinate(-1, 0)),

    VERTICAL_UP(new Coordinate(0, 1)),
    VERTICAL_DOWN(new Coordinate(0, -1)),

    DIAGONAL_UP_RIGHT(new Coordinate(1, 1)),
    DIAGONAL_UP_LEFT(new Coordinate(-1, -1)),

    DIAGONAL_DOWN_LEFT(new Coordinate(1, -1)),
    DIAGONAL_DOWN_RIGHT(new Coordinate(-1, 1));
    
    private Coordinate coordinate_;

    Direction(Coordinate coordinate) {
        this.coordinate_ = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate_;
    }

}
