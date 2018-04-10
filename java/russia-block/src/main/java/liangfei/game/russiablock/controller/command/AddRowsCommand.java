package liangfei.game.russiablock.controller.command;

public class AddRowsCommand implements Command {
	
	private BoardCommandReceiver boardCommandReceiver;
	
	private int rows = 1;
	
	public AddRowsCommand(BoardCommandReceiver boardCommandReceiver, int rows) {
		this.boardCommandReceiver = boardCommandReceiver;
		this.rows = rows;
	}

	@Override
	public void execute() {
		boardCommandReceiver.addRows(rows);
	}

}
