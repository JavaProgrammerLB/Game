package liangfei.game.russiablock.controller.facade;

import java.util.HashMap;
import java.util.Map;

import liangfei.game.russiablock.controller.command.Command;

public class CommandMediator {
	
	private Map commandMap = new HashMap();
	
	public CommandMediator() {
		
	}
	
	public void invokeCommand(String order) {
		Command command = (Command) commandMap.get(order);
		command.execute();
	}

}
