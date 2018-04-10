package liangfei.game.russiablock.controller.command;

public class MoveBottomCommand implements Command {
	
	private MoveCommandReceiver moveCommandReceiver;

	public MoveBottomCommand(MoveCommandReceiver moveCommandReceiver) {
		this.moveCommandReceiver = moveCommandReceiver;
	}

	@Override
	public void execute() {
		moveCommandReceiver.moveBottom();
	}

}
