package views;
import java.util.Scanner;
import models.Game;

public class PlayerView {

    private Game game_;
    private Scanner input_;

    public PlayerView(Game game) {
        this.game_ = game;
        this.input_ = new Scanner(System.in);
    }
    
    public void interact() {
        this.game_.putToken(this.getColumn());
    }

    public void putToken() {
        this.game_.putToken(this.getColumn());
    }

    public int getColumn() {
        System.out.println(this.game_.getActiveColor() + " player turn. Enter the column (0-6):");
        return input_.nextInt();
    }

}
