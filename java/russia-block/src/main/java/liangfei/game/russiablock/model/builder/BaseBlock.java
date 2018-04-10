package liangfei.game.russiablock.model.builder;

import liangfei.game.russiablock.domain.Block;
import liangfei.game.russiablock.domain.BlockIterator;
import liangfei.game.russiablock.domain.Box;

/**
 * 
 * Block的享元对象
 * @author new
 *
 */

public class BaseBlock implements Block {
	
	private Box[] boxes;
	
	private Block nextBolck;
	
	private Block previousBolck;
	
	// 享元模式(Flyweight)，共享19个Block
	// 此类为享元对象
	public BaseBlock(Box[] boxes) {
		this.boxes = boxes;
	}
	
	// 包保护级，只允许Builder访问
	void setNextDirectionBolck(Block nextBolck) {
		this.nextBolck = nextBolck;
	}
	
	void setPreviousDirectionBolck(Block previousBolck) {
		this.previousBolck = previousBolck;
	}
	
	// 实现Block接口

	public Block getNextBolck() {
		return nextBolck;
	}

	public Block getPreviousBolck() {
		return previousBolck;
	}

	public Box getBox(int index) {
		if (index >= 0 && index < getBlockSize()) {
			return boxes[index];
		}
		return null;
	}

	public int getBlockSize() {
		return boxes.length;
	}

	public BlockIterator iterator() {
		return new BlockIterator(this);
	}
}
