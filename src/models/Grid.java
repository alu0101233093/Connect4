package models;

public class Grid {
	private String[][] gridSlots_;
    private Coordinate actualDirection_;
    private Direction[] directions_;

	Grid() {
		this.gridSlots_ = new String[6][7];
        this.actualDirection_ = new Coordinate(0, 0);
        this.directions_ = Direction.values();

        for (int row = 0; row < Game.ROWS; row++) {
            for (int column = 0; column < Game.COLUMNS; column++) {
                this.gridSlots_[row][column] = "";
            }
        }
	}

	public String getSlot(int row, int column) {
		return this.gridSlots_[row][column];
	}

	public int placeToken(int column, String color) {
        int row = FirstFreeSlot(column);
		this.gridSlots_[row][column] = color;
		return row;
	}

	public int FirstFreeSlot(int column) {
		for(int i = 0; i < 6; i++) {
			if(gridSlots_[i][column] == "") {    
				return i;
            }
		}
		return -1;
	}

    private boolean outOfBounds(Coordinate actualCoordinate){
        return actualCoordinate.getX() < 0 || actualCoordinate.getX() > 5 
        || actualCoordinate.getY() < 0 || actualCoordinate.getY() > 6;
    }

    private int tokenCounter(Coordinate actualCoordinate, String color, int result) {
        if (outOfBounds(actualCoordinate) || this.gridSlots_[actualCoordinate.getX()][actualCoordinate.getY()] != color) {
            return result;
        } else {
            return tokenCounter(actualCoordinate.addition(actualDirection_), color, result + 1);
        }
    }
      
    public boolean checkWin(Coordinate lastTokenCoordinate, String color) {

        int TokenCount = 1;
        for (int directionIndex = 0; directionIndex < directions_.length && TokenCount < 4; directionIndex++) {
            if(directionIndex % 2 == 0){
                TokenCount = 1;
            }
            actualDirection_.setCoordinate(directions_[directionIndex].getCoordinate());
            TokenCount += tokenCounter(lastTokenCoordinate.addition(actualDirection_), color, 0);
        };
        return (TokenCount >= 4);
    }

    public boolean isTie() {

        for (int column = 0; column < Game.COLUMNS; column++) {
            if (!isColumnFull(column)) {
                return false;
            }
        }
        return true;
    }

    public boolean isColumnFull(int column) {
        return this.gridSlots_[Game.ROWS - 1][column] != "";
    }

}
