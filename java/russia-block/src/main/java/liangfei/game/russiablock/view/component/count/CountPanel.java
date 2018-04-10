package liangfei.game.russiablock.view.component.count;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class CountPanel extends JLabel {

	private static final long serialVersionUID = 1L;
	
	private String textPattern;
	
	public CountPanel() {
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		this.setOpaque(true);
		this.setForeground(Color.WHITE);
		this.setBackground(Color.decode("#333333"));
		this.setSize(90, 30);
	}

	public String getTextPattern() {
		return textPattern;
	}

	public void setTextPattern(String textPattern) {
		this.textPattern = textPattern;
		setCount(0);
	}
	
	public void setCount(int count) {
		if (textPattern != null && textPattern.length() > 0) {
			super.setText(textPattern.replaceAll("\\{0\\}", String.valueOf(count)));
		} else {
			super.setText(String.valueOf(count));
		}
	}

}
