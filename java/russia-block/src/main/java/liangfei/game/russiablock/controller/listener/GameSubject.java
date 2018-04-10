package liangfei.game.russiablock.controller.listener;

public interface GameSubject {
	
	public void addGameListener(GameListener gameListener);
	
	public void removeGameListener(GameListener gameListener);
	
}
