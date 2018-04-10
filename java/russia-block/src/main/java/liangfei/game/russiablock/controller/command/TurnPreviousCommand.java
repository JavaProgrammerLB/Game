package liangfei.game.russiablock.controller.command;

public class TurnPreviousCommand implements Command {
	
	private TurnCommandReceiver turnCommandReceiver;
	
	public TurnPreviousCommand(TurnCommandReceiver turnCommandReceiver) {
		this.turnCommandReceiver = turnCommandReceiver;
	}
	
	@Override
	public void execute() {
		turnCommandReceiver.turnPrevious();
	}

}
