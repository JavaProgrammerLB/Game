package liangfei.game.russiablock.view.decorator.box;

import java.awt.Color;
import java.awt.Graphics;

public abstract class ColorBoxDecorator implements BoxDecorator {
	
	public void drawBox(Graphics g, int x, int y, int size, int style) {
		g.setColor(getBoxColor(style));
		g.fill3DRect(x, y, size, size, true);
		if (size >= 8) {
			g.fill3DRect(x + 2, y + 2, size - 4, size - 4, true);
		}
		if (size >= 16) {
			g.fill3DRect(x + 4, y + 4, size - 8, size - 8, true);
		}
	}

	protected abstract Color getBoxColor(int style);
	
}
