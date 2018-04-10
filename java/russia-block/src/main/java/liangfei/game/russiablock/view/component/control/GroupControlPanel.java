package liangfei.game.russiablock.view.component.control;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import liangfei.game.russiablock.controller.facade.CommandFacade;
import liangfei.game.russiablock.view.component.CommandButton;
import liangfei.game.russiablock.view.component.TabPanel;

public class GroupControlPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private TabPanel groupTab;
	
	private JPanel boderPanel;
	
	protected CommandButton groupAButton, groupBButton, groupCButton, groupFreeButton;
	
	public GroupControlPanel(CommandFacade commandFacade) {
		this.setOpaque(false);
		this.setSize(180,100);
		this.setLayout(null);
		
		groupTab = new TabPanel("选择编组");
		groupTab.setSize(30, 100);
		groupTab.setLocation(0, 0);
		this.add(groupTab);
		
		boderPanel = new JPanel();
		boderPanel.setLayout(null);
		boderPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		boderPanel.setSize(150,100);
		boderPanel.setLocation(30, 0);
		this.add(boderPanel);
		
		groupAButton = new CommandButton("A");
		//groupAButton.addCommand(commandFacade.getReadyCommand());
		groupAButton.setBackground(Color.RED);
		groupAButton.setSize(40,40);
		groupAButton.setLocation(10,10);
		boderPanel.add(groupAButton);
		
		groupBButton = new CommandButton("B");
		//groupBButton.addCommand(commandFacade.getCancelCommand());
		groupBButton.setBackground(Color.YELLOW);
		groupBButton.setSize(40,40);
		groupBButton.setLocation(55,10);
		boderPanel.add(groupBButton);
		
		groupCButton = new CommandButton("C");
		//groupCButton.addCommand(commandFacade.getExitCommand());
		groupCButton.setBackground(Color.BLUE);
		groupCButton.setSize(40,40);
		groupCButton.setLocation(100,10);
		boderPanel.add(groupCButton);
		
		groupFreeButton = new CommandButton("自由");
		//groupFreeButton.addCommand(commandFacade.getExitCommand());
		groupFreeButton.setBackground(Color.GREEN);
		groupFreeButton.setSize(90,30);
		groupFreeButton.setLocation(30, 60);
		boderPanel.add(groupFreeButton);
	}

}

