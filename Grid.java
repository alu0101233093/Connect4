public class Grid {
	private Slot[][] gridSlots;

	Grid() {
		gridSlots = new Slot[6][7];
	}

	public String getSlot(int row, int col) {
		return gridSlots[row][col].get_color();
	}

	public boolean setSlot(int col, Slot slot) {
		if(gridSlots[5][col] != null)
			return false;

		gridSlots[checkLastSlot(col) + 1][col] = slot;
		return true;
	}

	public int checkLastSlot(int col){
		for(int i = 0; i < 6; i++){
			if(gridSlots[i][col] == null)
				return i - 1;
		}
		return -1;
	}
}
