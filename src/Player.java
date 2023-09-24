import java.util.Scanner;

public class Player {
    private String color_;
    private Scanner input_;

    //private grid y eliminar grid del metodo set
    Player (String color) {
        color_ = color;
        input_ = new Scanner(System.in);
    }

    public String getColor() {
        return color_;
    }

    public int setToken() {
        System.out.println(color_ + " player turn");
        String input = input_.next();
        return Integer.parseInt(input);
    }
}
