package liangfei.game.russiablock.controller.listener;

public interface ReadySubject {
	
	public void addReadyListener(ReadyListener readyListener);
	
	public void removeReadyListener(ReadyListener readyListener);
	
}
