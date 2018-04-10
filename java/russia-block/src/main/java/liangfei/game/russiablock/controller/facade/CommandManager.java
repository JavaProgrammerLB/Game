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
	
	public Command getExitCommand() {
		return exitCommand;
	}

	public Command getReadyCommand() {
		return readyCommand;
	}

	public Command getCancelCommand() {
		return cancelCommand;
	}

	public Command getMoveBottomCommand() {
		return moveBottomCommand;
	}

	public Command getMoveDownCommand() {
		return moveDownCommand;
	}

	public Command getMoveLeftCommand() {
		return moveLeftCommand;
	}

	public Command getMoveRightCommand() {
		return moveRightCommand;
	}

	public Command getTurnNextCommand() {
		return turnNextCommand;
	}

	public Command getTurnPreviousCommand() {
		return turnPreviousCommand;
	}

	public Command getSpeedDownCommand() {
		return speedDownCommand;
	}

	public Command getSpeedUpCommand() {
		return speedUpCommand;
	}

	public Command getClearBoardCommand() {
		return clearBoardCommand;
	}

	public Command getAddOneRowCommand() {
		return addOneRowCommand;
	}

	public Command getRemoveOneRowCommand() {
		return removeOneRowCommand;
	}

	public Command getAddTwoRowsCommand() {
		return addTowRowsCommand;
	}

	public Command getRemoveTwoRowsCommand() {
		return removeTowRowsCommand;
	}

	public Command getAddThreeRowsCommand() {
		return addThreeRowsCommand;
	}

	public Command getRemoveThreeRowsCommand() {
		return removeThreeRowsCommand;
	}

}
