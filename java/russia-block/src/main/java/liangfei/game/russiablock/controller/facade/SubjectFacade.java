package liangfei.game.russiablock.controller.facade;

import liangfei.game.russiablock.controller.listener.BlockSubject;
import liangfei.game.russiablock.controller.listener.BoardSubject;
import liangfei.game.russiablock.controller.listener.GameSubject;
import liangfei.game.russiablock.controller.listener.LocationSubject;
import liangfei.game.russiablock.controller.listener.OverSubject;
import liangfei.game.russiablock.controller.listener.ReadySubject;
import liangfei.game.russiablock.controller.listener.RemoveRowsSubject;
import liangfei.game.russiablock.controller.listener.SpeedSubject;

public interface SubjectFacade {
	
	public GameSubject getGameSubject();
	
	public ReadySubject getReadySubject();
	
	public OverSubject getOverSubject();
	
	public BoardSubject getPlayBoardSubject();
	
	public BlockSubject getPlayBlockSubject();
	
	public LocationSubject getPlayLocationSubject();
	
	public SpeedSubject getSpeedSubject();
	
	public BlockSubject getNextBlockSubject();
	
	public BlockSubject getAfterBlockSubject();
	
	public RemoveRowsSubject getRemoveRowsSubject();

}
