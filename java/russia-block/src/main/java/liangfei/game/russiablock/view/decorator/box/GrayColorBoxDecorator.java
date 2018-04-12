package liangfei.game.russiablock.view.decorator.box;

import java.awt.Color;

public class GrayColorBoxDecorator extends ColorBoxDecorator {

	@Override
	protected Color getBoxColor(int style) {
		return Color.GRAY;
	}

}
