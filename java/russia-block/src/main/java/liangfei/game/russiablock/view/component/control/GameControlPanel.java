package liangfei.game.russiablock.view.component.control;

import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import liangfei.game.russiablock.controller.facade.CommandFacade;
import liangfei.game.russiablock.view.component.CommandButton;

public class GameControlPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	protected CommandButton readyButton, exerciseButton, cancelButton, exitButton;

	public GameControlPanel(CommandFacade commandFacade) {
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.setSize(180, 75);
		this.setLayout(null);

		readyButton = new CommandButton("准备");
		readyButton.addCommand(commandFacade.getReadyCommand());
		readyButton.setMnemonic(KeyEvent.VK_S);
		readyButton.setSize(75, 24);
		readyButton.setLocation(10, 10);
		this.add(readyButton);
		
		exerciseButton = new CommandButton("练习");
		exerciseButton.addCommand(commandFacade.getReadyCommand());
		exerciseButton.setSize(75, 24);
		exerciseButton.setLocation(90, 10);
		this.add(exerciseButton);

		cancelButton = new CommandButton("取消");
		cancelButton.addCommand(commandFacade.getCancelCommand());
		cancelButton.setSize(75, 24);
		cancelButton.setLocation(10, 40);
		this.add(cancelButton);

		exitButton = new CommandButton("退出");
		exitButton.addCommand(commandFacade.getExitCommand());
		exitButton.setSize(75, 24);
		exitButton.setLocation(90, 40);
		this.add(exitButton);
	}

}
