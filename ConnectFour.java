import java.util.Scanner;

public class ConnectFour {
	private Grid grid_;
	private boolean gameFinished_;
	private boolean redTurn_;
	private Scanner input_;

	ConnectFour() {
		grid_ = new Grid();
		gameFinished_ = false;
		input_ = new Scanner(System.in);
	}

	public int inputToInt() {
		String input = input_.next();
		return input.charAt(0) - '0';
		
	}

	public void StartGame() {
		int columnSelected = 0;
		while(!gameFinished_) {
			if(redTurn_){
				System.out.println("Red player turn");
				columnSelected = inputToInt();
				if(grid_.setSlot(columnSelected, "red")){
					if(checkwin("red")){
						System.out.println("Red player wins");
						gameFinished_ = true;
					}
					redTurn_ = false;
				} else {
					System.out.println("Column is full");
				}
			} else {
				System.out.println("Yellow player turn");
				columnSelected = inputToInt();
				if(grid_.setSlot(columnSelected, "yellow")){
					if(checkwin("yellow")){
						System.out.println("Yellow player wins");
						gameFinished_ = true;
					}
					redTurn_ = true;
				} else {
					System.out.println("Column is full");
				}
			}
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
