package liangfei.game.russiablock.controller.command;

public class SpeedDownCommand implements Command {
	
	private SpeedCommandReceiver speedCommandReceiver;
	
	public SpeedDownCommand(SpeedCommandReceiver speedCommandReceiver) {
		this.speedCommandReceiver = speedCommandReceiver;
	}

	@Override
	public void execute() {
		speedCommandReceiver.speedDown();
	}

}
