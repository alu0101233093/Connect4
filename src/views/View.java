package views;

import models.Game;

public class View{

    private Game game_;
    private boolean isResumed_;

    public View(Game game) {
        game_ = game;
    }

    public void play() {
        do {
            this.game_.nextTurn();
            new PlayerView(this.game_).interact();
            new GridView().printGrid(this.game_);
        } while (!this.game_.isFinished());
        this.isResumed_ = true;
        if (this.game_.isTie()) {
            System.out.println("Tie");
        } else {
            System.out.println(this.game_.getActiveColor() + " player wins");
        }
        
    }

    public boolean isResumed() {
        return isResumed_;
    }

}
