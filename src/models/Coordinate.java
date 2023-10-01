package models;
public class Coordinate{
    private int x_;
    private int y_;

    public Coordinate(){
        setCoordinate(0, 0);
    }

    Coordinate(int x, int y){
        setCoordinate(x, y);
    }

    public void setCoordinate(int x, int y){
        x_ = x;
        y_ = y;
    }

    public void setCoordinate(Coordinate copy){
        x_ = copy.getX();
        y_ = copy.getY();
    }

    public int getX(){
        return x_;
    }

    public int getY(){
        return y_;
    }

    public Coordinate addition(Coordinate otherCoordinate) {
        return new Coordinate(x_ + otherCoordinate.getX(), y_ + otherCoordinate.getY());
    }
}