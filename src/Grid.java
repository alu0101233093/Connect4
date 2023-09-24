public class Grid {
	private String[][] gridSlots_;
    private int count_;

	Grid() {
        this.count_ = 0;
		this.gridSlots_ = new String[6][7];

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                this.gridSlots_[row][col] = "";
            }
        }
	}

	public String getSlot(int row, int col) {
		return this.gridSlots_[row][col];
	}

	public int setSlot(int col, String color) {
        int row = FirstFreeSlot(col);
		this.gridSlots_[row][col] = color;
		return row;
	}

    public void printGrid() {
        System.out.println("0 1 2 3 4 5 6");
		for (int row = 5; row >= 0; row--) {
			for (int col = 0; col < 7; col++) {
				String tokenColor = getSlot(row, col);
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

	public int FirstFreeSlot(int col) {
		for(int i = 0; i < 6; i++) {
			if(gridSlots_[i][col] == "") {    
				return i;
            }
		}
		return -1;
	}

    public boolean checkHorizontal(String color) {
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
	}
}
