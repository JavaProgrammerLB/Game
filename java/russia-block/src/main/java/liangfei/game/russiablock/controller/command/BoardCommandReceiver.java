package liangfei.game.russiablock.controller.command;

public interface BoardCommandReceiver {
	
	public void clearBoard();
	
	public void addRows(int rows);
	
	public void removeRows(int rows);
	
}
