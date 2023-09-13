public class ConnectFour {
	private Grid grid_;
	private boolean redPlayerTurn_;
	private boolean gameFinished_;

	ConnectFour() {
		grid_ = new Grid();
		redPlayerTurn_ = true;
		gameFinished_ = false;
	}

	public void StartGame() {
		while(!gameFinished_) {

		}
	}

	public boolean checkwin(String color) {

		if (checkHorizontal(color, i, j)){
			return true;
		} else if (checkVertical(color, i, j)) 
			return true;
		} else if (checkDiagonal(color, i, j)) 
			return true;

		return false;
	}

	private boolean checkHorizontal(String color, int row, int col) {
		int count = 0;
		for (int j = col; j < col + 4 && j < 7; j++) {
			if (grid_.getSlot(row, j) == color) {
				count++;
				if (count == 4) return true;
			} else {
				count = 0;
			}
		}
		return false;
	}

	public vertical(color: string): Boolean{
        for(let i = 0; i < 7; i++){
            let n: number = 0;
            for(let j = 0; j < 6; j++){
                if(this.tablero_[j][i].get_color() == color)
                    n++;
                else
                    n = 0;
                if(n == 4)
                    return true;
            }
        }
        return false;
    }

	private boolean checkVertical(String color, int row, int col) {
		int count = 0;
		for (int i = row; i < row + 4 && i < 6; i++) {
			if (grid_[i][col].get_color() == color) {
				count++;
				if (count == 4) return true;
			} else {
				count = 0;
			}
		}
		return false;
	}

	private boolean checkDiagonal(String color, int row, int col) {
		int count = 0;
		for (int i = row, j = col; i < row + 4 && i < 6 && j < 7; i++, j++) {
			if (grid_[i][j].get_color() == color) {
				count++;
				if (count == 4) return true;
			} else {
				count = 0;
			}
		}
		return false;
	}
}
