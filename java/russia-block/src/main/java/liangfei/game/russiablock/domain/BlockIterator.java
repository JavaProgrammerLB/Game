package liangfei.game.russiablock.domain;

import java.util.NoSuchElementException;

/**
 * 
 * Block的迭代器
 * @author 梁飞 liangfei0201@163.com
 *
 */
public class BlockIterator {
	
	private Block block;
	
	private int i;
	
	/**
	 * 构造子注入所需迭代的Block
	 * @param Block - 要迭代的Block
	 */
	public BlockIterator(Block block) {
		this.block = block;
		i = 0;
	}
	
	// 迭代器模式实现 ----
	
	/**
	 * 判断BlockIterator是否还有下一Box
	 * 示例:
	 * Block block = getBlock(); // 获取block
	 * BlockIterator blockIterator = block.getBlockIterator();
	 * while (blockIterator.hasNextBox()) {
	 *     Box box = blockIterator.nextBox();
	 *     todo(box); // 使用读取的box
	 * }
	 * @return boolean - true 有下一Box; false 没有下一Box
	 */
	public boolean hasNextBox() {
		if (block == null) {
			return false;
		}
		return block.getBlockSize() > i;
	}
	
	/**
	 * 返回迭代的下一Box
	 * 若没有下一Box则抛出NoSuchElementException
	 * @return Box - 下一可用Box
	 */
	public Box nextBox() {
		if (! hasNextBox()) {
			throw new NoSuchElementException("has no box!");
		}
		return block.getBox(i ++);
	}
	
}
