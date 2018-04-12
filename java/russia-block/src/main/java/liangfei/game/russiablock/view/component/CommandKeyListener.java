package liangfei.game.russiablock.view.component;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.SwingUtilities;

import liangfei.game.russiablock.controller.command.Command;

public class CommandKeyListener implements KeyListener {
	
	private Map commandMap;
	
	public CommandKeyListener(Map commandMap) {
		this.commandMap = commandMap;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Integer key = new Integer(e.getKeyCode());
		if (commandMap.containsKey(key)) {
			Command command = (Command)commandMap.get(key);
			command.execute();
		}
		SwingUtilities.getRootPane(e.getComponent()).requestFocus();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// ignore
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// ignore
	}
}
