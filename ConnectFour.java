public class ConnectFour {
	private Grid grid_;
	private boolean gameFinished_;
	private Turn turn_;

	ConnectFour() {
		grid_ = new Grid();
		turn_ = new Turn();
		gameFinished_ = false;
	}

	public void StartGame() {
		while(!gameFinished_) {

		}
	}

	public boolean checkwin(String color) {
		if (checkHorizontal(color) || checkVertical(color) || checkDiagonal(color)) {
			return true;
		} else {
			return false;	
		}
	}

}
