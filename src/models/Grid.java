package models;
public class Grid {
	private String[][] gridSlots_;
    private WinChecker winChecker_;

	Grid() {
		this.gridSlots_ = new String[6][7];
        this.winChecker_ = new WinChecker(this.gridSlots_);

        for (int row = 0; row < 6; row++) {
            for (int column = 0; column < 7; column++) {
                this.gridSlots_[row][column] = "";
            }
        }
	}

	public String getSlot(int row, int column) {
		return this.gridSlots_[row][column];
	}

	public int setSlot(int column, String color) {
        int row = FirstFreeSlot(column);
		this.gridSlots_[row][column] = color;
		return row;
	}

    public void printGrid() {
        System.out.println("0 1 2 3 4 5 6");
		for (int row = 5; row >= 0; row--) {
			for (int column = 0; column < 7; column++) {
				String tokenColor = getSlot(row, column);
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

	public int FirstFreeSlot(int column) {
		for(int i = 0; i < 6; i++) {
			if(gridSlots_[i][column] == "") {    
				return i;
            }
		}
		return -1;
	}

    public boolean checkWin(Coordinate token, String color) {
        return winChecker_.checker(token.getX(), token.getY(), color);
    }


    /*public boolean checkHorizontal(String color) {
		for(int i = 0; i < 6; i++) {
            count_ = 0;
            for(int j = 0; j < 7; j++) {
                if (tokenCounter (i, j, color)) {
                    return true;
                }
            }
        }
        return false;
	}
    
	public boolean checkVertical(String color) {
		for(int i = 0; i < 7; i++) {
            count_ = 0;
            for(int j = 0; j < 6; j++) {
                if (tokenCounter (j, i, color)) {
                    return true;
                }
            }
        }
        return false;
	}

	public boolean checkDiagonal (String color) {
        if (checkDiagonalsAscendant(color) || checkDiagonalsDescendant(color)) {
            return true;
        } else {
            return false;
        }
	}

    public boolean checkDiagonalsAscendant (String color) {
        for(int i = 1; i <= 3; i++) {
            count_ = 0;
            for (int j = 0; j < 7 - i; j++) {
                if (tokenCounter (j, j + i, color)) {
                    return true;
                }
            }
        }

        for(int i = 5; i >= 3; i--) {
            count_ = 0;
            for (int j = 0; j <= i; j++) {
                if (tokenCounter (i - j, j, color)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonalsDescendant (String color) {
        for(int i = 2; i >= 0; i--) {
            count_ = 0;
            for (int j = 0; j < 6 - i; j++) {
                if (tokenCounter (i + j, j, color)) {
                    return true;
                }
            }
        }

        for(int i = 3; i > 0; i--) {
            count_ = 0;
            for (int j = 0; j < 7 - i; j++) {
				if (tokenCounter (5 - j, j + i, color)) {
                    return true;
                }
            }
        }
        return false;
    }

	public boolean tokenCounter (int row, int col, String color) {
		if(gridSlots_[row][col] == color) {
            count_++;
        } else {
            count_ = 0;
        }

        if(count_ == 4) {
            return true;
        }
		return false;
	} */
}
