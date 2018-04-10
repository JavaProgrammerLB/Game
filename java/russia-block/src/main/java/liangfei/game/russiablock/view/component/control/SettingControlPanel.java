package liangfei.game.russiablock.view.component.control;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import liangfei.game.russiablock.controller.facade.CommandFacade;

public class SettingControlPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	protected JCheckBox audioCheckBox, gifCheckBox, topCheckBox;

	public SettingControlPanel(CommandFacade commandFacade) {
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.setSize(180, 40);
		this.setLayout(null);

		audioCheckBox = new JCheckBox("声音", true);
		// audioCheckBox.addCommand(commandFacade.getReadyCommand());
		// audioCheckBox.addActionListener(new CommandActionListener());
		audioCheckBox.setOpaque(false);
		audioCheckBox.setForeground(Color.WHITE);
		audioCheckBox.setSize(55, 24);
		audioCheckBox.setLocation(10, 8);
		this.add(audioCheckBox);
		
		gifCheckBox = new JCheckBox("动画", true);
		// gifCheckBox.addCommand(commandFacade.getReadyCommand());
		// gifCheckBox.addActionListener(new CommandActionListener());
		gifCheckBox.setOpaque(false);
		gifCheckBox.setForeground(Color.WHITE);
		gifCheckBox.setSize(55, 24);
		gifCheckBox.setLocation(65, 8);
		this.add(gifCheckBox);
		
		topCheckBox = new JCheckBox("最前", true);
		// topsideCheckBox.addCommand(commandFacade.getReadyCommand());
		// topsideCheckBox.addActionListener(new CommandActionListener());
		topCheckBox.setOpaque(false);
		topCheckBox.setForeground(Color.WHITE);
		topCheckBox.setSize(55, 24);
		topCheckBox.setLocation(120, 8);
		this.add(topCheckBox);
	}

}

