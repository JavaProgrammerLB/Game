package liangfei.game.russiablock.view.component.panel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class LogoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel logoPanel;
	
	public LogoPanel() {
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.setSize(180, 55);
		this.setLayout(null);
		
		logoPanel = new JLabel("圣诞俄罗斯");
		logoPanel.setHorizontalAlignment(JLabel.CENTER);
		logoPanel.setForeground(Color.WHITE);
		logoPanel.setSize(180, 55);
		logoPanel.setLocation(0, 0);
		this.add(logoPanel);
	}

}
