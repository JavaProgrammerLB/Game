package liangfei.game.russiablock.view.g2;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import liangfei.game.russiablock.controller.facade.CommandFacade;
import liangfei.game.russiablock.controller.facade.SubjectFacade;
import liangfei.game.russiablock.view.component.CommandKeyListener;
import liangfei.game.russiablock.view.component.GameFrame;
import liangfei.game.russiablock.view.component.control.ControlMenu;
import liangfei.game.russiablock.view.component.panel.PlayPanel;

public class G2GameFrame extends GameFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ControlMenu controlMenu;
	
	private G2ControlPanel controlPanel;
	
	private PlayPanel playPanel1, playPanel2;

	public G2GameFrame(CommandFacade commandFacade1, SubjectFacade subjectFacade1,
			CommandFacade commandFacade2, SubjectFacade subjectFacade2) {
		// 命令控制 ---------
		Map keyCommandMap = new HashMap();
		keyCommandMap.put(new Integer(KeyEvent.VK_E), commandFacade1.getTurnNextCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_5), commandFacade1.getTurnPreviousCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_S), commandFacade1.getMoveLeftCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_F), commandFacade1.getMoveRightCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_D), commandFacade1.getMoveDownCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_A), commandFacade1.getMoveBottomCommand());
		
		keyCommandMap.put(new Integer(KeyEvent.VK_UP), commandFacade2.getTurnNextCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_END), commandFacade2.getTurnPreviousCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_LEFT), commandFacade2.getMoveLeftCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_RIGHT), commandFacade2.getMoveRightCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_DOWN), commandFacade2.getMoveDownCommand());
		keyCommandMap.put(new Integer(KeyEvent.VK_SPACE), commandFacade2.getMoveBottomCommand());
		this.getRootPane().addKeyListener(new CommandKeyListener(keyCommandMap));
		
		controlMenu = new ControlMenu(commandFacade1);
		this.setJMenuBar(controlMenu);
		
		controlPanel = new G2ControlPanel(commandFacade1, commandFacade2);
		controlPanel.setLocation(700, 20);
		this.getContentPane().add(controlPanel);
		
		// 视图呈现 ---------
		playPanel1 = new PlayPanel(subjectFacade1);
		playPanel1.setLocation(5, 5);
		this.getContentPane().add(playPanel1);
		
		playPanel2 = new PlayPanel(subjectFacade2);
		playPanel2.setLocation(350, 5);
		this.getContentPane().add(playPanel2);
		
		this.setSize(800, 600);
		this.setVisible(true);
	}

}
