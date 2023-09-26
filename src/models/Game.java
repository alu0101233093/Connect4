package models;
public class Game {
	private Grid grid_;
	private Turn turn_;
	private int tokenToCheck_;


	public Game() {
		this.grid_ = new Grid();
		this.turn_ = new Turn(this.grid_);
		this.tokenToCheck_ = -1;
	}

	public void nextTurn() {
		this.turn_.nextTurn();
	}

	public String getSlotColor (int row, int column) {
		return this.grid_.getSlot(row, column);
	}

	public String getActiveColor() {
		return this.turn_.getActiveColor();
	}

	public void putToken(int column) {
		this.turn_.putToken(column);
	}

	public boolean isWin() {
		return this.grid_.checkWin(this.tokenToCheck_, this.getActiveColor());
	}	


	

	/*public boolean checkWin(String color) {
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
	}*/
	
}

/*public void startGame() {
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
	}*/


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