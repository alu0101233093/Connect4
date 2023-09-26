package models;
public class WinChecker {
    private String[][] grid_;
    private String color_;
    private Coordinate coordinate_;
    private Coordinate actualDirection_;
    private static final Coordinate[] directions_ = new Coordinate[] {
        new Coordinate(1, 0),
        new Coordinate(-1, 0), 
        new Coordinate(0, 1), 
        new Coordinate(0, -1), 
        new Coordinate(1, 1), 
        new Coordinate(-1, -1), 
        new Coordinate(-1, 1), 
        new Coordinate(1, -1),

    };

    WinChecker(String[][] grid){
        this.grid_ = grid;

        this.color_ = "";
        this.coordinate_ = new Coordinate(0, 0);
        this.actualDirection_ = new Coordinate(0, 0);
    }

    private void setData(int x, int y, String color){
        coordinate_.setCoordinate(x, y);
        this.color_ = color;
    }

    private boolean outOfBounds(Coordinate actual){
        return actual.getX() < 0 || actual.getX() > 5 || actual.getY() < 0 || actual.getY() > 6;
    }

    private int counter(Coordinate actual, int result) {
        if (outOfBounds(actual) || grid_[actual.getX()][actual.getY()] != color_) {
            return result;
        } else {
            return counter(actual.sum(actualDirection_), result + 1);
        }
    }
      
    public boolean checker(int x, int y, String color) {
        setData(x, y, color);

        int i = 0; int count = 1;
        while (i < directions_.length && count < 4){
            if(i % 2 == 0){
                count = 1;
            }
            actualDirection_.setCoordinate(directions_[i]);
            count += counter(coordinate_.sum(actualDirection_), 0);
            i++;
        };

        if (count >= 4)
            return true;
        else
            return false;
    }
}
