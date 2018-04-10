package liangfei.game.russiablock.controller.command;

public class ReadyCommand implements Command {
	
	private ReadyCommandReceiver readyCommandReceiver;

	public ReadyCommand(ReadyCommandReceiver readyCommandReceiver) {
		this.readyCommandReceiver = readyCommandReceiver;
	}

	@Override
	public void execute() {
		readyCommandReceiver.ready();
	}

}
