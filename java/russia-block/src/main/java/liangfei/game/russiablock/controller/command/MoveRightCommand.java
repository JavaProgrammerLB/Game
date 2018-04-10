package liangfei.game.russiablock.controller.command;

public class MoveRightCommand implements Command {

	private MoveCommandReceiver moveCommandReceiver;

	public MoveRightCommand(MoveCommandReceiver moveCommandReceiver) {
		this.moveCommandReceiver = moveCommandReceiver;
	}

	@Override
	public void execute() {
		moveCommandReceiver.moveRight();
	}

}
