package liangfei.game.russiablock.controller.command;

public class TurnNextCommand implements Command {
	
	private TurnCommandReceiver turnCommandReceiver;
	
	public TurnNextCommand(TurnCommandReceiver turnCommandReceiver) {
		this.turnCommandReceiver = turnCommandReceiver;
	}

	@Override
	public void execute() {
		turnCommandReceiver.turnNext();
	}

}
