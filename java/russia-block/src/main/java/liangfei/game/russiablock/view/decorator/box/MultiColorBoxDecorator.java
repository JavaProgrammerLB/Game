package liangfei.game.russiablock.view.decorator.box;

import java.awt.Color;

public class MultiColorBoxDecorator extends ColorBoxDecorator {
	
	public static final Color[] BOX_COLORS = {
			Color.GRAY,
			Color.decode("#cc3300"),
			Color.decode("#6699ff"),
			Color.decode("#cc66cc"),
			Color.decode("#ff9900"), 
			Color.decode("#99cc00"),
			Color.decode("#33ccff"),
			Color.decode("#ffcc00"), 
	};

	@Override
	protected Color getBoxColor(int style) {
		if (style < 0 || style >= BOX_COLORS.length) {
			return Color.BLACK;
		}
		return BOX_COLORS[style];
	}

}
