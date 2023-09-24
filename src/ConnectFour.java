public class ConnectFour {
	private Grid grid_;
	private WinChecker winChecker_; 
	private Player[] players_;

	ConnectFour() {
		this.grid_ = new Grid();
		this.winChecker_ = new WinChecker();
		this.players_ = new Player[] {new Player("Red"), new Player("Yellow")};
	}

	public static void main(String[] args) {
		ConnectFour Connect4 = new ConnectFour();
		Connect4.startGame();
	}

	public void startGame() {
		int playerTurn = 0;
		int selectedColumn = 0;
		int row = 0;
		boolean finished = false;
		this.grid_.printGrid();
		while(!finished) {
			playerTurn = playerTurn%2;
			do{
				selectedColumn = players_[playerTurn].setToken();
			}while(grid_.FirstFreeSlot(selectedColumn) > 5);

			row = grid_.setSlot(selectedColumn, players_[playerTurn].getColor());
			finished = winChecker_.checker(row, selectedColumn, players_[playerTurn].getColor());

			// if (players_[playerTurn].setToken(this.grid_)) {
			// 	gameFinished_ = this.checkWin(this.players_[playerTurn].getColor());
			// 	playerTurn++;
			// } else {
			// 	System.out.println("Column is full");
			// }
		}
	}

	public boolean checkWin(String color) {
		if (this.grid_.checkHorizontal(color) ||
			this.grid_.checkVertical(color) ||
			this.grid_.checkDiagonal(color)) {

			System.out.println(color + " player wins");
			this.grid_.printGrid();
			return true;
		} else {
			this.grid_.printGrid();
			return false;	
		}
	}
	
}


// public class ConnectFour {
// 	private Grid grid_;
// 	private boolean gameFinished_;
// 	private Player[] players_;

// 	ConnectFour() {
// 		this.grid_ = new Grid();
// 		this.gameFinished_ = false;
// 		this.players_ = new Player[] {new Player("Red"), new Player("Yellow")};
// 	}

// 	public static void main(String[] args) {
// 		ConnectFour Connect4 = new ConnectFour();
// 		Connect4.startGame();
// 	}

// 	public void startGame() {
// 		int playerTurn = 0;
// 		this.grid_.printGrid();
// 		while(!gameFinished_) {
// 			playerTurn = playerTurn%2;
// 			if (players_[playerTurn].setToken(this.grid_)) {
// 				gameFinished_ = this.checkWin(this.players_[playerTurn].getColor());
// 				playerTurn++;
// 			} else {
// 				System.out.println("Column is full");
// 			}
// 		}
// 	}

// 	public boolean checkWin(String color) {
// 		if (this.grid_.checkHorizontal(color) ||
// 			this.grid_.checkVertical(color) ||
// 			this.grid_.checkDiagonal(color)) {

// 			System.out.println(color + " player wins");
// 			this.grid_.printGrid();
// 			return true;
// 		} else {
// 			this.grid_.printGrid();
// 			return false;	
// 		}
// 	}
	
// }