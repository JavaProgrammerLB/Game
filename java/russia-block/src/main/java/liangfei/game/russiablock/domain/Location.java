package liangfei.game.russiablock.domain;

public class Location {
	
	private int row;
	
	private int col;
	
	public Location() {
		this(0, 0);
	}
	
	public Location(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}
	
	// TODO 以下方法产生过多实例，待重构
	
	public Location getLeftLocation() {
		return new Location(row, col - 1);
	}
	
	public Location getRightLocation() {
		
		return new Location(row, col + 1);
	}
	
	public Location getDownLocation() {
		return new Location(row + 1, col);
	}
	
	public Location getUpLocation() {
		return new Location(row - 1, col);
	}
	
	public boolean equals(Location otherLocation) {
		if (this == otherLocation) {
			return true;
		}
		if (otherLocation == null) {
			return false;
		}
		return (row == otherLocation.getRow() && col == otherLocation.getCol());
	}

}
