package liangfei.game.russiablock.view.g6;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import liangfei.game.russiablock.controller.facade.CommandFacade;
import liangfei.game.russiablock.controller.facade.SubjectFacade;
import liangfei.game.russiablock.view.component.CommandKeyListener;
import liangfei.game.russiablock.view.component.GameFrame;
import liangfei.game.russiablock.view.component.control.ChatPanel;
import liangfei.game.russiablock.view.component.control.ControlMenu;
import liangfei.game.russiablock.view.component.panel.LogoPanel;
import liangfei.game.russiablock.view.component.panel.PlayPanel;
import liangfei.game.russiablock.view.component.panel.WatchPanel;

public class G6GameFrame extends GameFrame {

	private static final long serialVersionUID = 1L;

	private LogoPanel logoPanel;

	private ControlMenu controlMenu;

	private G6ControlPanel controlPanel;

	private ChatPanel chatPanel;

	private PlayPanel playPanel;

	private WatchPanel[] watchPanels;

	public G6GameFrame(CommandFacade commandFacade, SubjectFacade subjectFacade) {
		logoPanel = new LogoPanel();
		logoPanel.setLocation(605, 5);
		this.getContentPane().add(logoPanel);

		// 命令控制 ---------
		Map keyCommandMap = new HashMap();
		keyCommandMap.put(new Integer(KeyEvent.VK_UP), commandFacade.getTurnNextCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_DOWN), commandFacade.getTurnPreviousCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_LEFT), commandFacade.getMoveLeftCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_RIGHT), commandFacade.getMoveRightCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_END), commandFacade.getMoveDownCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_SPACE), commandFacade.getMoveBottomCommand());
		// 模拟道具 -----
		keyCommandMap.put(new Integer(KeyEvent.VK_1), commandFacade.getSpeedUpCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_2), commandFacade.getSpeedDownCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_3), commandFacade.getClearBoardCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_4), commandFacade.getAddOneRowCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_5), commandFacade.getRemoveOneRowCommand());
		this.getRootPane()
				.addKeyListener(new CommandKeyListener(keyCommandMap));

		controlMenu = new ControlMenu(commandFacade);
		this.setJMenuBar(controlMenu);

		chatPanel = new ChatPanel();
		chatPanel.setLocation(605, 70);
		this.getContentPane().add(chatPanel);

		controlPanel = new G6ControlPanel(commandFacade);
		controlPanel.setLocation(605, 310);
		this.getContentPane().add(controlPanel);

		// 视图呈现 ---------
		watchPanels = new WatchPanel[6];
		for (int i = 0; i < 5; i++) {
			watchPanels[i] = new WatchPanel(subjectFacade);
			this.getContentPane().add(watchPanels[i]);
		}
		watchPanels[0].setLocation(135, 5);
		watchPanels[1].setLocation(10, 5);
		watchPanels[2].setLocation(10, 280);
		watchPanels[3].setLocation(135, 280);
		watchPanels[4].setLocation(260, 280);

		playPanel = new PlayPanel(subjectFacade);
		playPanel.setLocation(260, 5);
		this.getContentPane().add(playPanel);

		this.setSize(800, 600);
		this.setVisible(true);
	}
}
