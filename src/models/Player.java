package models;

public class Player {
    private Grid grid_;
    private String color_;

    Player (String color, Grid grid) {
        this.color_ = color;
        this.grid_ = grid;
    }

    public String getColor() {
        return color_;
    }

    public int putToken(int column) {
        return this.grid_.placeToken(column, this.color_);
    }
}
