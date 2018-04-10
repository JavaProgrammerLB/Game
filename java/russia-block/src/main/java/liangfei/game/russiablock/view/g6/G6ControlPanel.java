package liangfei.game.russiablock.view.g6;

import javax.swing.JPanel;

import liangfei.game.russiablock.controller.facade.CommandFacade;
import liangfei.game.russiablock.view.component.control.GameControlPanel;
import liangfei.game.russiablock.view.component.control.GroupControlPanel;
import liangfei.game.russiablock.view.component.control.SettingControlPanel;

public class G6ControlPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private GroupControlPanel groupControlPanel;
	
	private SettingControlPanel settingControlPanel;

	private GameControlPanel GameControlPanel;

	public G6ControlPanel(CommandFacade commandFacade) {
		this.setOpaque(false);
		this.setSize(180, 235);
		this.setLayout(null);

		groupControlPanel = new GroupControlPanel(commandFacade);
		groupControlPanel.setLocation(0, 0);
		this.add(groupControlPanel);
		
		settingControlPanel = new SettingControlPanel(commandFacade);
		settingControlPanel.setLocation(0, 110);
		this.add(settingControlPanel);
		
		GameControlPanel = new GameControlPanel(commandFacade);
		GameControlPanel.setLocation(0, 160);
		this.add(GameControlPanel);
	}

}
