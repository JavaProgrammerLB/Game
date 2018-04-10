package liangfei.game.russiablock.controller.command;

public class MoveLeftCommand implements Command {

	private MoveCommandReceiver moveCommandReceiver;

	public MoveLeftCommand(MoveCommandReceiver moveCommandReceiver) {
		this.moveCommandReceiver = moveCommandReceiver;
	}

	@Override
	public void execute() {
		moveCommandReceiver.moveLeft();
	}

}
