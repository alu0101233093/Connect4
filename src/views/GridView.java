package views;

import models.Game;

public class GridView {

    public void printGrid(Game game) {
        System.out.println("0 1 2 3 4 5 6");
		for (int row = 5; row >= 0; row--) {
			for (int column = 0; column < 7; column++) {
				String tokenColor = game.getSlotColor(row, column);
				if (tokenColor.equals("Red")) {
					System.out.print("R ");
				} else if (tokenColor.equals("Yellow")) {
					System.out.print("Y ");
				} else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}
}
