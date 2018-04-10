package liangfei.game.russiablock.controller.command;

public class RemoveRowsCommand implements Command {
	
	private BoardCommandReceiver boardCommandReceiver;
	
	private int rows = 1;
	
	public RemoveRowsCommand(BoardCommandReceiver boardCommandReceiver, int rows) {
		this.boardCommandReceiver = boardCommandReceiver;
		this.rows = rows;
	}

	@Override
	public void execute() {
		boardCommandReceiver.removeRows(rows);
	}

}
