public class ConnectFour {
	private Grid grid_;
	private boolean gameFinished_;

	ConnectFour() {
		grid_ = new Grid();
		gameFinished_ = false;
	}

	public void StartGame() {
		while(!gameFinished_) {

		}
	}

	public boolean checkwin(String color) {
		if (grid_.checkHorizontal(color) || grid_.checkVertical(color) || grid_.checkDiagonal(color)) {
			return true;
		} else {
			return false;	
		}
	}

}
