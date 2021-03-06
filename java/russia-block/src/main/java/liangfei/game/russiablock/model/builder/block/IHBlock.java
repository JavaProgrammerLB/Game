package liangfei.game.russiablock.model.builder.block;

import liangfei.game.russiablock.domain.Block;
import liangfei.game.russiablock.domain.BlockIterator;
import liangfei.game.russiablock.domain.Box;

public class IHBlock implements Block {
	
	private static final Box[] boxes = {
		new Box(0, -1, 1),
		new Box(0, 0, 1),
		new Box(0, 1, 1),
		new Box(0, 2, 1)
	};
	
	//private static final IShapeVerticalBlock iShapeVerticalBlock = new IShapeVerticalBlock();
	
	public IHBlock() {
		
	}

	@Override
	public Block getNextBolck() {
		return new IVBlock();
	}

	@Override
	public Block getPreviousBolck() {
		return new IVBlock();
	}

	@Override
	public Box getBox(int index) {
		if (index >= 0 && index < getBlockSize()) {
			return boxes[index];
		}
		return null;
	}

	@Override
	public int getBlockSize() {
		return boxes.length;
	}

	@Override
	public BlockIterator iterator() {
		return new BlockIterator(this);
	}
}
