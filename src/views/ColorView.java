package views;


public class ColorView {

    public void printColor(String color) {
        if (color.equals("Red")) {
            System.out.print("R ");
        } else if (color.equals("Yellow")) {
            System.out.print("Y ");
        } else {
            System.out.print("- ");
        }
    }
}
