package liangfei.game.russiablock.controller.command;

public class CancelCommand implements Command {
	
	private ReadyCommandReceiver readyCommandReceiver;

	public CancelCommand(ReadyCommandReceiver readyCommandReceiver) {
		this.readyCommandReceiver = readyCommandReceiver;
	}

	@Override
	public void execute() {
		readyCommandReceiver.cancel();
	}

}
