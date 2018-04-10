package liangfei.game.russiablock.domain;

import liangfei.game.russiablock.controller.command.Command;

public interface Magic {
	
	public Command getCommand();
	
	public String getDescription();

}
