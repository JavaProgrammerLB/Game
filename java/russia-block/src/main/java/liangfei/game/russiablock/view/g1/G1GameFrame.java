package liangfei.game.russiablock.view.g1;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import liangfei.game.russiablock.controller.facade.CommandFacade;
import liangfei.game.russiablock.controller.facade.SubjectFacade;
import liangfei.game.russiablock.view.component.CommandKeyListener;
import liangfei.game.russiablock.view.component.GameFrame;
import liangfei.game.russiablock.view.component.control.ControlMenu;
import liangfei.game.russiablock.view.component.panel.PlayPanel;

public class G1GameFrame extends GameFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ControlMenu controlMenu;
	
	private G1ControlPanel controlPanel;
	
	private PlayPanel playPanel;

	public G1GameFrame(CommandFacade commandFacade, SubjectFacade subjectFacade) {
		// 命令控制 ---------
		Map keyCommandMap = new HashMap();
		keyCommandMap.put(new Integer(KeyEvent.VK_UP), commandFacade.getTurnNextCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_DOWN), commandFacade.getTurnPreviousCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_LEFT), commandFacade.getMoveLeftCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_RIGHT), commandFacade.getMoveRightCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_END), commandFacade.getMoveDownCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_SPACE), commandFacade.getMoveBottomCommand());
		
		// 模拟道具 -----
		keyCommandMap.put(new Integer(KeyEvent.VK_PERIOD), commandFacade.getSpeedUpCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_COMMA), commandFacade.getSpeedDownCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_1), commandFacade.getClearBoardCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_2), commandFacade.getAddOneRowCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_3), commandFacade.getRemoveOneRowCommand());
		this.getRootPane().addKeyListener(new CommandKeyListener(keyCommandMap));
		
		controlMenu = new ControlMenu(commandFacade);
		this.setJMenuBar(controlMenu);
		
		controlPanel = new G1ControlPanel(commandFacade);
		controlPanel.setLocation(350, 20);
		this.getContentPane().add(controlPanel);
		
		// 视图呈现 ---------
		playPanel = new PlayPanel(subjectFacade);
		playPanel.setLocation(5, 5);
		this.getContentPane().add(playPanel);
		
		this.setSize(450, 600);
		this.setVisible(true);
	}

}
