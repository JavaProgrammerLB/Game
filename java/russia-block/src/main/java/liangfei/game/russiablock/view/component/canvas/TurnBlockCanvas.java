package liangfei.game.russiablock.view.component.canvas;

import liangfei.game.russiablock.domain.Block;
import liangfei.game.russiablock.view.decorator.box.BoxDecorator;

public class TurnBlockCanvas extends BlockCanvas {
	
	private static final long serialVersionUID = 1L;
	
	public TurnBlockCanvas() {
		super();
	}
	
	public TurnBlockCanvas(BoxDecorator boxDecorator) {
		super(boxDecorator);
	}

	@Override
	protected Block getBlock(Block block) {
		if (block == null) {
			return null;
		}
		return block.getNextBolck();
	}

}
