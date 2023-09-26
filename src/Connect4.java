import models.Game;
import views.View;

public class Connect4 {

    private Game game_;
    private View view_;

    Connect4() {
        this.game_ = new Game();
        this.view_ = new View(this.game_);
    }

    private void playGame() {
        do {
            this.view_.play();
        }while(!this.view_.isResumed());
    }

    public static void main(String[] args) {
        new Connect4().playGame();
    }
    
    
}
