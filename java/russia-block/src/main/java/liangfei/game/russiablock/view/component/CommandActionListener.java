package liangfei.game.russiablock.view.component;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import liangfei.game.russiablock.controller.command.CommandInvoker;

public class CommandActionListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		CommandInvoker commandInvoker = (CommandInvoker)e.getSource();
		commandInvoker.invokeCommand();
		SwingUtilities.getRootPane((Component)e.getSource()).requestFocus();
	}

}
