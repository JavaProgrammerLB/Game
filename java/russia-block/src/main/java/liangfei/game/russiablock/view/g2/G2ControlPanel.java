package liangfei.game.russiablock.view.g2;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import liangfei.game.russiablock.controller.facade.CommandFacade;
import liangfei.game.russiablock.view.component.CommandButton;

public class G2ControlPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	protected CommandButton readyButton, cancelButton, exitButton;

	protected CommandButton speedUpButton, speedDownButton;

	public G2ControlPanel(CommandFacade commandFacade1,
			CommandFacade commandFacade2) {
		this.setOpaque(false);
		this.setSize(100, 220);
		this.setLayout(null);

		readyButton = new CommandButton("开始");
		readyButton.addCommand(commandFacade1.getReadyCommand());
		readyButton.addCommand(commandFacade2.getReadyCommand());
		readyButton.setMnemonic(KeyEvent.VK_S);
		readyButton.setSize(80, 24);
		readyButton.setLocation(0, 0);
		this.add(readyButton);

		cancelButton = new CommandButton("停止");
		cancelButton.addCommand(commandFacade1.getCancelCommand());
		cancelButton.addCommand(commandFacade2.getCancelCommand());
		cancelButton.setSize(80, 24);
		cancelButton.setLocation(0, 40);
		this.add(cancelButton);

		speedUpButton = new CommandButton("加速");
		speedUpButton.addCommand(commandFacade1.getSpeedUpCommand());
		speedUpButton.addCommand(commandFacade2.getSpeedUpCommand());
		speedUpButton.setSize(80, 24);
		speedUpButton.setLocation(0, 80);
		this.add(speedUpButton);

		speedDownButton = new CommandButton("减速");
		speedDownButton.addCommand(commandFacade1.getSpeedDownCommand());
		speedDownButton.addCommand(commandFacade2.getSpeedDownCommand());
		speedDownButton.setSize(80, 24);
		speedDownButton.setLocation(0, 120);
		this.add(speedDownButton);

		exitButton = new CommandButton("退出");
		exitButton.addCommand(commandFacade1.getExitCommand());
		exitButton.setSize(80, 24);
		exitButton.setLocation(0, 160);
		this.add(exitButton);

	}

}
