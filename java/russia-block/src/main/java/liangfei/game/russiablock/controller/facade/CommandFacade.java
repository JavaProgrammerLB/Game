package liangfei.game.russiablock.controller.facade;

import liangfei.game.russiablock.controller.command.Command;

public interface CommandFacade {
	
	// 游戏控制命令 -------
	
	public Command getExitCommand();
	
	public Command getReadyCommand();
	
	public Command getCancelCommand();
	
	// 方块控制命令 -------
	
	public Command getMoveLeftCommand();
	
	public Command getMoveRightCommand();
	
	public Command getMoveDownCommand();
	
	public Command getMoveBottomCommand();
	
	public Command getTurnNextCommand();
	
	public Command getTurnPreviousCommand();
	
	// 道具使用命令 -------
	
	public Command getSpeedUpCommand();
	
	public Command getSpeedDownCommand();
	
	public Command getClearBoardCommand();
	
	public Command getAddOneRowCommand();
	
	public Command getRemoveOneRowCommand();
	
	public Command getAddTwoRowsCommand();
	
	public Command getRemoveTwoRowsCommand();
	
	public Command getAddThreeRowsCommand();
	
	public Command getRemoveThreeRowsCommand();

}
