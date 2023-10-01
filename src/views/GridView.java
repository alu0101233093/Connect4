package views;

import models.Game;

public class GridView {

    public void printGrid(Game game) {
        System.out.println("0 1 2 3 4 5 6");
		for (int row = Game.ROWS - 1; row >= 0; row--) {
			for (int column = 0; column < Game.COLUMNS; column++) {
				new ColorView().printColor(game.getSlotColor(row, column));
			}
			System.out.println();
		}
	}
}
