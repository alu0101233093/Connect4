package models;
public class Game {

	public static final int ROWS = 6;
	public static final int COLUMNS = 7;

	private Grid grid_;
	private Turn turn_;
	private Coordinate tokenToCheck_;


	public Game() {
		this.grid_ = new Grid();
		this.turn_ = new Turn(this.grid_);
		this.tokenToCheck_ = new Coordinate();
	}

	public void nextTurn() {
		this.turn_.nextTurn();
	}

	public String getSlotColor(int row, int column) {
		return this.grid_.getSlot(row, column);
	}

	public String getActiveColor() {
		return this.turn_.getActiveColor();
	}

	public void putToken(int column) {
		this.tokenToCheck_.setCoordinate(this.turn_.putToken(column), column);
	}

	public boolean isWin() {
		return this.grid_.checkWin(this.tokenToCheck_, this.getActiveColor());
	}	

	public boolean isTie() {
		return this.grid_.isTie();
	}

	public boolean isFinished() {
		return this.isWin() || this.isTie();
	}

	public boolean isColumnFull(int column) {
		return this.grid_.isColumnFull(column);
	}
}