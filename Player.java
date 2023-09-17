import java.util.Scanner;

public class Player {
    private String color_;
    private Scanner input_;

    Player (String color) {
        color_ = color;
        input_ = new Scanner(System.in);
    }

    public String getColor() {
        return color_;
    }

    public boolean setToken(Grid gameGrid) {

        System.out.println(color_ + " player turn");
        String input = input_.next();
        return gameGrid.setSlot(Integer.parseInt(input), color_);

    }


}
