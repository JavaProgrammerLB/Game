package liangfei.game.russiablock.controller.command;

public class MoveDownCommand implements Command {

	private MoveCommandReceiver moveCommandReceiver;

	public MoveDownCommand(MoveCommandReceiver moveCommandReceiver) {
		this.moveCommandReceiver = moveCommandReceiver;
	}

	@Override
	public void execute() {
		moveCommandReceiver.moveDown();
	}

}
