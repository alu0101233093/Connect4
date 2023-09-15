public class Grid {
    // clase slot no hace falta (get de get y setter llamando setter)
	private Slot[][] gridSlots_;
    private int count_;

	Grid() {
		gridSlots_ = new Slot[6][7];
        count_ = 0;
	}

    // get de un get
	public String getSlot(int row, int col) {
		return gridSlots_[row][col].get_color();
	}

    // set de un set
	public boolean setSlot(int col, String color) {
		if(gridSlots_[5][col] != null)
			return false;

		gridSlots_[FirstFreeSlot(col)][col].set_color(color);
		return true;
	}

	public int FirstFreeSlot(int col) {
		for(int i = 0; i < 6; i++) {
			if(gridSlots_[i][col] == null)
				return i;
		}
		return -1;
	}

    public boolean checkHorizontal(String color) {
		for(int i = 0; i < 6; i++) {
            count_ = 0;
            for(int j = 0; j < 7; j++) {
                tokenCounter (i, j, color);
            }
        }
        return false;
	}

	public boolean checkVertical(String color) {
		for(int i = 0; i < 7; i++) {
            count_ = 0;
            for(int j = 0; j < 6; j++) {
                tokenCounter (j, i, color);
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
		if(gridSlots_[row][col].get_color() == color) {
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
