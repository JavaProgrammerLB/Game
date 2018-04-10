package liangfei.game.russiablock.view.component.control;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import liangfei.game.russiablock.controller.facade.CommandFacade;
import liangfei.game.russiablock.view.component.CommandMenuItem;

public class ControlMenu extends JMenuBar {

	private static final long serialVersionUID = 1L;

	JMenu controlMenu, settingMenu, helpMenu;

	CommandMenuItem readyItem, cancelItem, exitItem;

	CommandMenuItem blockColorSettingItem, groupColorSettingItem,
			keySettingItem, audioSettingItem;

	CommandMenuItem keyHelpItem, viewHelpItem, functionHelpItem, aboutMeItem;

	public ControlMenu(CommandFacade commandFacade) {
		controlMenu = new JMenu("控制(C)");
		this.add(controlMenu);
		readyItem = new CommandMenuItem("开始");
		controlMenu.add(readyItem);
		readyItem.addCommand(commandFacade.getReadyCommand());
		cancelItem = new CommandMenuItem("停止");
		controlMenu.add(cancelItem);
		cancelItem.addCommand(commandFacade.getCancelCommand());
		controlMenu.addSeparator();
		exitItem = new CommandMenuItem("退出");
		controlMenu.add(exitItem);
		exitItem.addCommand(commandFacade.getExitCommand());
		settingMenu = new JMenu("设置(S)");
		this.add(settingMenu);
		keySettingItem = new CommandMenuItem("控制键设置");
		settingMenu.add(keySettingItem);
		blockColorSettingItem = new CommandMenuItem("方块颜色设置");
		settingMenu.add(blockColorSettingItem);
		groupColorSettingItem = new CommandMenuItem("分组颜色设置");
		settingMenu.add(groupColorSettingItem);
		audioSettingItem = new CommandMenuItem("声音设置");
		settingMenu.add(audioSettingItem);
		helpMenu = new JMenu("帮助(H)");
		this.add(helpMenu);
		keyHelpItem = new CommandMenuItem("控制键帮助");
		helpMenu.add(keyHelpItem);
		viewHelpItem = new CommandMenuItem("面板帮助");
		helpMenu.add(viewHelpItem);
		functionHelpItem = new CommandMenuItem("功能帮助");
		helpMenu.add(functionHelpItem);
		helpMenu.addSeparator();
		aboutMeItem = new CommandMenuItem("关于俄罗斯方块");
		helpMenu.add(aboutMeItem);
	}

}
