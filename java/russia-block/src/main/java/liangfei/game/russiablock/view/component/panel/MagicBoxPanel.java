package liangfei.game.russiablock.view.component.panel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MagicBoxPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public MagicBoxPanel() {
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		this.setForeground(Color.WHITE);
		this.setBackground(Color.decode("#333333"));
		this.setSize(16 * 12, 20);
	}

}
