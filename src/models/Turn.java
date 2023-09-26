package models;
public class Turn {
    
    private Grid grid_;
    private Player[] players_;
    private int activePlayer_;


    Turn(Grid grid) {
        this.grid_ = grid;
        this.players_ = new Player[] {new Player("Red", this.grid_), new Player("Yellow", this.grid_)};
        this.activePlayer_ = 0;
    }

    public Player getActivePlayer() {
        return this.players_[this.activePlayer_];
    }

    public String getActiveColor() {
        return this.getActivePlayer().getColor();
    }

    public void nextTurn() {
        this.activePlayer_ = (this.activePlayer_ + 1) % 2;
    }

    public void putToken(int column) {
        this.getActivePlayer().setToken(column);
    }


}
