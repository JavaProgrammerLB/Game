package liangfei.game.russiablock.view.decorator.box;

import java.awt.Graphics;
import java.awt.Image;

public abstract class ImageBoxDecorator implements BoxDecorator {

	@Override
	public void drawBox(Graphics g, int x, int y, int size, int style) {
		g.drawImage(getBoxImage(style), x, y, size, size, null);
	}
	
	protected abstract Image getBoxImage(int style);
	
}
