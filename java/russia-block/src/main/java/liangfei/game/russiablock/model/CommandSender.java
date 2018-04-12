package liangfei.game.russiablock.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import liangfei.game.russiablock.controller.command.Command;
import liangfei.game.russiablock.controller.command.SpeedCommandReceiver;
import liangfei.game.russiablock.controller.listener.SpeedListener;
import liangfei.game.russiablock.controller.listener.SpeedSubject;

public class CommandSender implements SpeedSubject, SpeedCommandReceiver {
	
	private static final int MAX_INTERVAL = 240;
	
	private static final int MIN_INTERVAL = 40;
	
	private static final int SPEED_LEVEL = 10;
	
	private static final int SPEED_LEVEL_SIZE = (MAX_INTERVAL - MIN_INTERVAL) / SPEED_LEVEL;
	
	private Command command;
	
	public CommandSender(Command command) {
		this.command = command;
	}
	
	private int intervalTime = MAX_INTERVAL;
	
	private void setIntervalTime(int i) {
		if (i >= MIN_INTERVAL && i <= MAX_INTERVAL) {
			intervalTime = i;
			if (commandRunner != null) {
				commandRunner.setIntervalTime(intervalTime);
			}
			fireSpeedChanged();
		}
	}
	
	private int getIntervalTime() {
		return intervalTime;
	}
	
	// SpeedCommandReceiver ---------
	@Override
	public void speedUp() {
		if (! isStart) {
			return ;
		}
		setIntervalTime(getIntervalTime() - 20);
	}

	@Override
	public void speedDown() {
		if (! isStart) {
			return ;
		}
		setIntervalTime(getIntervalTime() + 20);
	}
	
	// GameStateListener -------
	
	private boolean isStart = false;
	
	private CommandRunner commandRunner;
	
	public void gameStarted() {
		isStart = true;
		commandRunner = new CommandRunner(command);
		setIntervalTime(MAX_INTERVAL);
		new Thread(commandRunner).start();
	}

	public void gameStoped() {
		isStart = false;
		if (commandRunner != null) {
			commandRunner.stopRun();
		}
		commandRunner = null;
	}
	
	// 速度变化通知 ---------
	
	private Set speedListenerSet = new HashSet();

	@Override
	public void addSpeedListener(SpeedListener speedListener) {
		speedListenerSet.add(speedListener);
	}

	@Override
	public void removeSpeedListener(SpeedListener speedListener) {
		speedListenerSet.remove(speedListener);
	}
	
	private void fireSpeedChanged() {
		if (speedListenerSet != null && ! speedListenerSet.isEmpty()) {
			for (Iterator iterator = speedListenerSet.iterator(); iterator.hasNext(); ) {
				SpeedListener listener = (SpeedListener)iterator.next();
				listener.speedChanged(getSpeed());
			}
		}
	}
	
	// 计算速度级别 -----
	
	private int getSpeed() {
		int speed = (getIntervalTime() - MIN_INTERVAL) / SPEED_LEVEL_SIZE;
		if (speed < 0) {
			speed = 0;
		}
		if (speed > 9) {
			speed = 9;
		}
		return 9 - speed;
	}
	
}
