public class ConnectFour {
	private Grid grid_;
	private boolean gameFinished_;
	private Player players_[];

	ConnectFour() {
		this.grid_ = new Grid();
		gameFinished_ = false;
		players_ = new Player[] {new Player("Red"), new Player("Yellow")};
	}

	public static void main(String[] args) {
		ConnectFour C4 = new ConnectFour();
		C4.StartGame();
	}

	public Grid getGrid() {
		return this.grid_;
	}

	public void StartGame() {
		int playerTurn = 0;
		grid_.printGrid();
		while(!gameFinished_) {
			playerTurn = playerTurn%2;
			if (players_[playerTurn].setToken(grid_)) {
				if(checkwin(players_[playerTurn].getColor())){
					System.out.println(players_[playerTurn].getColor() + " player wins");
					gameFinished_ = true;
				}
				playerTurn++;
				grid_.printGrid();
			} else {
				System.out.println("Column is full");
			}
		}
	}

	public boolean checkwin(String color) {
		if (grid_.checkHorizontal(color) || 
			grid_.checkVertical(color) || 
			grid_.checkDiagonal(color)) {
			return true;
		} else {
			return false;	
		}
	}
	
}
