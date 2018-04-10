package liangfei.game.russiablock.controller.facade;

import liangfei.game.russiablock.controller.command.BoardCommandReceiver;
import liangfei.game.russiablock.controller.command.GroupCommandReceiver;
import liangfei.game.russiablock.controller.command.MoveCommandReceiver;
import liangfei.game.russiablock.controller.command.ReadyCommandReceiver;
import liangfei.game.russiablock.controller.command.SpeedCommandReceiver;
import liangfei.game.russiablock.controller.command.TurnCommandReceiver;

public interface ReceiverFacade {
	
	public TurnCommandReceiver getTurnCommandReceiver();
	
	public MoveCommandReceiver getMoveCommandReceiver();
	
	public SpeedCommandReceiver getSpeedCommandReceiver();
	
	public BoardCommandReceiver getBoardCommandReceiver();
	
	public ReadyCommandReceiver getReadyCommandReceiver();
	
	public GroupCommandReceiver getGroupCommandReceiver();
	
}
