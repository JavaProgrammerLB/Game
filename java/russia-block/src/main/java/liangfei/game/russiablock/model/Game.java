package liangfei.game.russiablock.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import liangfei.game.russiablock.controller.listener.GameListener;
import liangfei.game.russiablock.controller.listener.GameSubject;
import liangfei.game.russiablock.controller.listener.OverListener;
import liangfei.game.russiablock.controller.listener.ReadyListener;
import liangfei.game.russiablock.model.resolver.StartResolver;
import liangfei.game.russiablock.model.resolver.StopResolver;

/**
 * 
 * 游戏总控制类
 * 
 * @author 梁飞 liangfei0201@163.com
 * 
 */
public class Game implements GameSubject, ReadyListener, OverListener {

	private List players;
	
	private StartResolver startResolver;
	
	private StopResolver stopResolver;
	
	// 构造子注入StartResolver,StopResolver (策略模式) --------
	
	/**
	 * @param startResolver -游戏是否开始决策者
	 * @param stopResolver -游戏是否结束决策者
	 */
	public Game(StartResolver startResolver, StopResolver stopResolver, int members) {
		this.startResolver = startResolver;
		this.stopResolver = stopResolver;
		players = new ArrayList(members);
	}
	
	// palyer manager --------
	
	public void addPlayer(Player player) {
		player.setGameSubject(this);
		player.getReadySubject().addReadyListener(this);
		player.getOverSubject().addOverListener(this);
		players.add(player);
	}
	
	public void removePlayer(Player player) {
		player.setGameSubject(null);
		player.getReadySubject().removeReadyListener(this);
		player.getOverSubject().removeOverListener(this);
		players.remove(player);
	}

	// GameCommandReceiver --------
	
	private boolean isStart = false;

	private void start() {
		if (! isStart) {
			isStart = true;
			fireGameStarted();
		}
	}
	
	private void stop() {
		if (isStart) {
			isStart = false;
			fireGameStoped();
		}
	}
	
	// Player准备状态监听 ---------
	@Override
	public void readyStateChanged(boolean isReady) {
		checkStart();
		if (! isReady) {
			checkStop();
		}
	}
	
	private void checkStart() {
		if (startResolver.isStart(getReadyStates())) {
			start();
		}
	}
	
	private List getReadyStates() {
		List readyStates = new ArrayList(players.size());
		for (int i = 0; i < players.size(); i ++) {
			readyStates.add(new Boolean(((Player)players.get(i)).isReady()));
		}
		return readyStates;
	}
	
	// Player结束状态监听 ---------
	@Override
	public void gameOvered() {
		checkStop();
	}
	
	private void checkStop() {
		if (stopResolver.isStop(getOverStates())) {
			stop();
		}
	}
	
	private List getOverStates() {
		List overStates = new ArrayList(players.size());
		for (int i = 0; i < players.size(); i ++) {
			// TODO Over状态获取待考虑
			// overStates.add(new Boolean(((Player)players.get(i)).isOver()));
		}
		return overStates;
	}
	
	//Game状态变化通知 (观察者模式)
	
	private Set gameStateListenerSet = new HashSet();

	@Override
	public void addGameListener(GameListener gameStateListener) {
		gameStateListenerSet.add(gameStateListener);
	}

	@Override
	public void removeGameListener(GameListener gameStateListener) {
		gameStateListenerSet.remove(gameStateListener);
	}
	
	private void fireGameStarted() {
		if (gameStateListenerSet != null && ! gameStateListenerSet.isEmpty()) {
			for (Iterator iterator = gameStateListenerSet.iterator(); iterator.hasNext(); ) {
				GameListener listener = (GameListener)iterator.next();
				listener.gameStarted();
			}
		}
	}
	
	private void fireGameStoped() {
		if (gameStateListenerSet != null && ! gameStateListenerSet.isEmpty()) {
			for (Iterator iterator = gameStateListenerSet.iterator(); iterator.hasNext(); ) {
				GameListener listener = (GameListener)iterator.next();
				listener.gameStoped();
			}
		}
	}

}
