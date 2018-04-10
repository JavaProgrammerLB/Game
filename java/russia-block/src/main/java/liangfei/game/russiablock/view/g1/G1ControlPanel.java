package liangfei.game.russiablock.view.g1;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import liangfei.game.russiablock.controller.facade.CommandFacade;
import liangfei.game.russiablock.view.component.CommandButton;

public class G1ControlPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected CommandButton readyButton, cancelButton, exitButton;
	
	protected CommandButton speedUpButton, speedDownButton;
	
	public G1ControlPanel(CommandFacade commandFacade) {
		this.setOpaque(false);
		this.setSize(100,300);
		this.setLayout(null);

		readyButton = new CommandButton("开始");
		readyButton.addCommand(commandFacade.getReadyCommand());
		readyButton.setMnemonic(KeyEvent.VK_S);
		readyButton.setSize(80, 24);
		readyButton.setLocation(0, 0);
		this.add(readyButton);
		
		cancelButton = new CommandButton("停止");
		cancelButton.addCommand(commandFacade.getCancelCommand());
		cancelButton.setSize(80, 24);
		cancelButton.setLocation(0, 50);
		this.add(cancelButton);
		
		speedUpButton = new CommandButton("加速");
		speedUpButton.addCommand(commandFacade.getSpeedUpCommand());
		speedUpButton.setSize(80, 24);
		speedUpButton.setLocation(0, 100);
		this.add(speedUpButton);
		
		speedDownButton = new CommandButton("减速");
		speedDownButton.addCommand(commandFacade.getSpeedDownCommand());
		speedDownButton.setSize(80, 24);
		speedDownButton.setLocation(0, 150);
		this.add(speedDownButton);
		
		exitButton = new CommandButton("退出");
		exitButton.addCommand(commandFacade.getExitCommand());
		exitButton.setSize(80, 24);
		exitButton.setLocation(0, 200);
		this.add(exitButton);
	}

}
