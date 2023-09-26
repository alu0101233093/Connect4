package views;

import models.Game;

public class View extends WithGameView{

    private boolean isResumed_;

    public View(Game game) {
        super(game);
        isResumed_ = false;
    }

    public void play() {
        do {
            this.game.nextTurn();
            new PlayerView(this.game).interact();
            new GridView().printGrid(this.game);
        } while (!this.game.isWin());
        isResumed_ = true;
        System.out.println(this.game.getActiveColor() + " player wins");
    }

    public boolean isResumed() {
        return isResumed_;
    }

}
