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

    public int getColumn() {
        System.out.println(this.game_.getActiveColor() + " player turn. Enter the column (0-6):");
        int input = input_.nextInt();
        while (input < 0 || input > Game.COLUMNS - 1 || this.game_.isColumnFull(input)) {
            System.out.println("Invalid column. Enter the column (0-6):");
            input = input_.nextInt();
        }
        return input;
    }

    public void putToken() {
        this.game_.putToken(this.getColumn());
    }
    
    public void interact() {
        this.putToken();
    }

}
