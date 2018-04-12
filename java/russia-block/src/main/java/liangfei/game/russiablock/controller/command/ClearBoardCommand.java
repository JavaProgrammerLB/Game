package liangfei.game.russiablock.controller.command;

public class ClearBoardCommand implements Command {
	
	private BoardCommandReceiver boardCommandReceiver;
	
	public ClearBoardCommand(BoardCommandReceiver boardCommandReceiver) {
		this.boardCommandReceiver = boardCommandReceiver;
	}

	@Override
	public void execute() {
		boardCommandReceiver.clearBoard();
	}

}
