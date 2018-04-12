package liangfei.game.russiablock.model.builder.block;

import liangfei.game.russiablock.domain.Block;
import liangfei.game.russiablock.domain.BlockIterator;
import liangfei.game.russiablock.domain.Box;

public class IVBlock implements Block {
	
	private static final Box[] boxes = {
		new Box(-1, 0, 2),
		new Box(0, 0, 2),
		new Box(1, 0, 2),
		new Box(2, 0, 3)
	};
	
	//private static final IShapeHorizontalBlock iShapeHorizontalBlock = new IShapeHorizontalBlock();
	
	public IVBlock() {
		
	}

	@Override
	public Block getNextBolck() {
		return new IHBlock();
	}

	@Override
	public Block getPreviousBolck() {
		return new IHBlock();
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
