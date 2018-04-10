package liangfei.game.russiablock.controller.command;

public class SpeedUpCommand implements Command {
	
	private SpeedCommandReceiver speedCommandReceiver;
	
	public SpeedUpCommand(SpeedCommandReceiver speedCommandReceiver) {
		this.speedCommandReceiver = speedCommandReceiver;
	}

	@Override
	public void execute() {
		speedCommandReceiver.speedUp();
	}

}
