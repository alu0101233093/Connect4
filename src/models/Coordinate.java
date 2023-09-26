package models;
public class Coordinate{
    private int x_;
    private int y_;

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
        return x_;
    }

    public Coordinate sumar(Coordinate sumando) {
        return new Coordinate(x_ + sumando.getX(), y_ + sumando.getY());
    }
}