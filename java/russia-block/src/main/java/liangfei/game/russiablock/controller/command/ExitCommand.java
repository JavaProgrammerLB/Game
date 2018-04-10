package liangfei.game.russiablock.controller.command;

public class ExitCommand implements Command {
	
	public ExitCommand() {
		
	}

	@Override
	public void execute() {
		System.exit(0);
	}

}
