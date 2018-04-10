package liangfei.game.russiablock.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import liangfei.game.russiablock.controller.command.BoardCommandReceiver;
import liangfei.game.russiablock.controller.command.GroupCommandReceiver;
import liangfei.game.russiablock.controller.command.MoveCommandReceiver;
import liangfei.game.russiablock.controller.command.MoveDownCommand;
import liangfei.game.russiablock.controller.command.ReadyCommandReceiver;
import liangfei.game.russiablock.controller.command.SpeedCommandReceiver;
import liangfei.game.russiablock.controller.command.TurnCommandReceiver;
import liangfei.game.russiablock.controller.facade.ReceiverFacade;
import liangfei.game.russiablock.controller.facade.SubjectFacade;
import liangfei.game.russiablock.controller.listener.BlockSubject;
import liangfei.game.russiablock.controller.listener.BoardSubject;
import liangfei.game.russiablock.controller.listener.GameListener;
import liangfei.game.russiablock.controller.listener.GameSubject;
import liangfei.game.russiablock.controller.listener.LocationSubject;
import liangfei.game.russiablock.controller.listener.OverSubject;
import liangfei.game.russiablock.controller.listener.ReadyListener;
import liangfei.game.russiablock.controller.listener.ReadySubject;
import liangfei.game.russiablock.controller.listener.RemoveRowsSubject;
import liangfei.game.russiablock.controller.listener.SpeedSubject;
import liangfei.game.russiablock.model.builder.BlockBuilder;
import liangfei.game.russiablock.model.builder.StandardBlockBuilder;
import liangfei.game.russiablock.model.provider.RandomProvider;

public class Player implements SubjectFacade, ReceiverFacade, ReadyCommandReceiver, ReadySubject, GameListener {

	private List previewQueue;
	
	private BoardContext boardContext;
	
	private BlockContext blockContext;
	
	private CommandSender downCommandSender;
	
	private Member member;
	
	public Player() {
		previewQueue = createPreviewQueue();
		boardContext = new BoardContext(24, 12);
		blockContext = new BlockContext((Preview)previewQueue.get(0), boardContext, boardContext);
		downCommandSender = new CommandSender(new MoveDownCommand(getMoveCommandReceiver()));
	}
	
	private List createPreviewQueue() {
		BlockBuilder blockBuilder = new StandardBlockBuilder();
		RandomProvider randomProvider = new RandomProvider(blockBuilder.build());
		Preview afterPreview = new Preview(randomProvider);
		Preview nextPreview = new Preview(afterPreview);
		previewQueue = new ArrayList();
		previewQueue.add(nextPreview);
		previewQueue.add(afterPreview);
		return previewQueue;
	}
	
	// GameSubject -----
	
	private GameSubject gameSubject;
	
	public void setGameSubject(GameSubject gameSubject) {
		if (this.gameSubject != null) {
			this.gameSubject.removeGameListener(this);
		}
		if (gameSubject != null) {
			gameSubject.addGameListener(this);
		}
		this.gameSubject = gameSubject;
	}
	
	public void gameStarted() {
		boardContext.clearBoard();
		blockContext.gameStarted();
		downCommandSender.gameStarted();
	}
	
	public void gameStoped() {
		blockContext.gameStoped();
		downCommandSender.gameStoped();
		isReady = false;
	}
	
	// PlayCommandReceiver -----------
	
	private boolean isReady = false;

	public boolean isReady() {
		return isReady;
	}
	
	public void ready() {
		if (! isReady) {
			isReady = true;
			fireReadyStateChanged();
		}
	}

	public void cancel() {
		if (isReady) {
			isReady = false;
			fireReadyStateChanged();
		}
	}
	
	// ReadySubject -----------
	
	private Set readyListenerSet = new HashSet();

	public void addReadyListener(ReadyListener readyListener) {
		readyListenerSet.add(readyListener);
	}

	public void removeReadyListener(ReadyListener readyListener) {
		readyListenerSet.remove(readyListener);
	}
	
	private void fireReadyStateChanged() {
		if (readyListenerSet != null && ! readyListenerSet.isEmpty()) {
			for (Iterator iterator = readyListenerSet.iterator(); iterator.hasNext(); ) {
				ReadyListener listener = (ReadyListener)iterator.next();
				listener.readyStateChanged(isReady);
			}
		}
	}
	
	// SubjectFacade -----------
	
	public GameSubject getGameSubject() {
		return gameSubject;
	}
	
	public ReadySubject getReadySubject() {
		return this;
	}
	
	public OverSubject getOverSubject() {
		return boardContext;
	}
	
	public BoardSubject getPlayBoardSubject() {
		return boardContext;
	}

	public BlockSubject getPlayBlockSubject() {
		return blockContext;
	}

	public LocationSubject getPlayLocationSubject() {
		return blockContext;
	}

	public BlockSubject getNextBlockSubject() {
		return (Preview)previewQueue.get(0);
	}

	public BlockSubject getAfterBlockSubject() {
		return (Preview)previewQueue.get(1);
	}
	
	public SpeedSubject getSpeedSubject() {
		return downCommandSender;
	}
	
	public RemoveRowsSubject getRemoveRowsSubject() {
		return boardContext;
	}

	// ReceiverFacade ------------

	public TurnCommandReceiver getTurnCommandReceiver() {
		return blockContext;
	}

	public MoveCommandReceiver getMoveCommandReceiver() {
		return blockContext;
	}

	public SpeedCommandReceiver getSpeedCommandReceiver() {
		return downCommandSender;
	}

	public BoardCommandReceiver getBoardCommandReceiver() {
		return boardContext;
	}

	public ReadyCommandReceiver getReadyCommandReceiver() {
		return this;
	}

	public GroupCommandReceiver getGroupCommandReceiver() {
		return member;
	}

}
