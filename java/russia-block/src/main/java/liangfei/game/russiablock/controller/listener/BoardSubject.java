package liangfei.game.russiablock.controller.listener;

public interface BoardSubject {
	
	public void addBoardListener(BoardListener boardListener);
	
	public void removeBoardListener(BoardListener boardListener);
	
}
