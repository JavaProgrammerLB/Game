package liangfei.game.russiablock.controller.facade;

import liangfei.game.russiablock.controller.command.AddRowsCommand;
import liangfei.game.russiablock.controller.command.CancelCommand;
import liangfei.game.russiablock.controller.command.ClearBoardCommand;
import liangfei.game.russiablock.controller.command.Command;
import liangfei.game.russiablock.controller.command.ExitCommand;
import liangfei.game.russiablock.controller.command.MoveBottomCommand;
import liangfei.game.russiablock.controller.command.MoveDownCommand;
import liangfei.game.russiablock.controller.command.MoveLeftCommand;
import liangfei.game.russiablock.controller.command.MoveRightCommand;
import liangfei.game.russiablock.controller.command.ReadyCommand;
import liangfei.game.russiablock.controller.command.RemoveRowsCommand;
import liangfei.game.russiablock.controller.command.SpeedDownCommand;
import liangfei.game.russiablock.controller.command.SpeedUpCommand;
import liangfei.game.russiablock.controller.command.TurnNextCommand;
import liangfei.game.russiablock.controller.command.TurnPreviousCommand;

public class CommandManager implements CommandFacade {
	
	private Command exitCommand;
	
	private Command readyCommand, cancelCommand;
	
	private Command moveLeftCommand, moveRightCommand, moveDownCommand, moveBottomCommand;
	
	private Command turnNextCommand, turnPreviousCommand;
	
	private Command speedUpCommand, speedDownCommand;
	
	private Command clearBoardCommand;
	
	private Command addOneRowCommand, removeOneRowCommand, addTowRowsCommand, removeTowRowsCommand, addThreeRowsCommand, removeThreeRowsCommand;

	public CommandManager(ReceiverFacade receiverFacade) {
		exitCommand = new ExitCommand();
		readyCommand = new ReadyCommand(receiverFacade.getReadyCommandReceiver());
		cancelCommand = new CancelCommand(receiverFacade.getReadyCommandReceiver());
		moveLeftCommand = new MoveLeftCommand(receiverFacade.getMoveCommandReceiver());
		moveRightCommand = new MoveRightCommand(receiverFacade.getMoveCommandReceiver());
		moveDownCommand = new MoveDownCommand(receiverFacade.getMoveCommandReceiver());
		moveBottomCommand = new MoveBottomCommand(receiverFacade.getMoveCommandReceiver());
		turnNextCommand = new TurnNextCommand(receiverFacade.getTurnCommandReceiver());
		turnPreviousCommand = new TurnPreviousCommand(receiverFacade.getTurnCommandReceiver());
		speedUpCommand = new SpeedUpCommand(receiverFacade.getSpeedCommandReceiver());
		speedDownCommand = new SpeedDownCommand(receiverFacade.getSpeedCommandReceiver());
		clearBoardCommand = new ClearBoardCommand(receiverFacade.getBoardCommandReceiver());
		addOneRowCommand = new AddRowsCommand(receiverFacade.getBoardCommandReceiver(), 1);
		removeOneRowCommand = new RemoveRowsCommand(receiverFacade.getBoardCommandReceiver(), 1);
		addTowRowsCommand = new AddRowsCommand(receiverFacade.getBoardCommandReceiver(), 2);
		removeTowRowsCommand = new RemoveRowsCommand(receiverFacade.getBoardCommandReceiver(), 2);
		addThreeRowsCommand = new AddRowsCommand(receiverFacade.getBoardCommandReceiver(), 3);
		removeThreeRowsCommand = new RemoveRowsCommand(receiverFacade.getBoardCommandReceiver(), 3);
	}
	
	// CommandFacade -----------

	@Override
	public Command getExitCommand() {
		return exitCommand;
	}

	@Override
	public Command getReadyCommand() {
		return readyCommand;
	}

	@Override
	public Command getCancelCommand() {
		return cancelCommand;
	}

	@Override
	public Command getMoveBottomCommand() {
		return moveBottomCommand;
	}

	@Override
	public Command getMoveDownCommand() {
		return moveDownCommand;
	}

	@Override
	public Command getMoveLeftCommand() {
		return moveLeftCommand;
	}

	@Override
	public Command getMoveRightCommand() {
		return moveRightCommand;
	}

	@Override
	public Command getTurnNextCommand() {
		return turnNextCommand;
	}

	@Override
	public Command getTurnPreviousCommand() {
		return turnPreviousCommand;
	}

	@Override
	public Command getSpeedDownCommand() {
		return speedDownCommand;
	}

	@Override
	public Command getSpeedUpCommand() {
		return speedUpCommand;
	}

	@Override
	public Command getClearBoardCommand() {
		return clearBoardCommand;
	}

	@Override
	public Command getAddOneRowCommand() {
		return addOneRowCommand;
	}

	@Override
	public Command getRemoveOneRowCommand() {
		return removeOneRowCommand;
	}

	@Override
	public Command getAddTwoRowsCommand() {
		return addTowRowsCommand;
	}

	@Override
	public Command getRemoveTwoRowsCommand() {
		return removeTowRowsCommand;
	}

	@Override
	public Command getAddThreeRowsCommand() {
		return addThreeRowsCommand;
	}

	@Override
	public Command getRemoveThreeRowsCommand() {
		return removeThreeRowsCommand;
	}

}
