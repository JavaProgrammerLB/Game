package liangfei.game.russiablock.model;

import liangfei.game.russiablock.controller.command.Command;

public class CommandRunner implements Runnable {
	
	private Command command;
	
	private boolean isRun = true;
	
	private int intervalTime = 0;
	
	public CommandRunner(Command command) {
		this.command = command;
	}

	@Override
	public void run() {
		while (isRun && intervalTime > 0) {
			try {
				Thread.sleep(intervalTime);
				if (command != null) {
					command.execute();
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void stopRun() {
		isRun = false;
	}

	public void setIntervalTime(int intervalTime) {
		this.intervalTime = intervalTime;
	}

}
