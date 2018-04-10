package liangfei.game.russiablock.view.component;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.JButton;

import liangfei.game.russiablock.controller.command.Command;
import liangfei.game.russiablock.controller.command.CommandInvoker;

public class CommandButton extends JButton implements CommandInvoker {

	private static final long serialVersionUID = 1L;
	
	public CommandButton() {
		super();
		this.addActionListener(new CommandActionListener());
	}

	public CommandButton(String text) {
		super(text);
		this.addActionListener(new CommandActionListener());
	}
	
	public CommandButton(String text, Icon icon) {
		super(text, icon);
		this.addActionListener(new CommandActionListener());
	}
	
	// CommandInvoker ---------
	
	private Set commands = new HashSet();

	@Override
	public void invokeCommand() {
		if (commands != null && ! commands.isEmpty()) {
			for (Iterator i = commands.iterator(); i.hasNext();) {
				Command c = (Command)i.next();
				if (c != null) {
					c.execute();
				}
			}
		}
	}

	public void addCommand(Command command) {
		commands.add(command);
	}
	
	public void removeCommand(Command command) {
		commands.remove(command);
	}

}
