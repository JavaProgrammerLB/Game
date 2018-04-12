package liangfei.game.russiablock.domain;


/**
 * 
 * 由多个(一般为4个)Box组成方块图形
 * 
 * @author 梁飞 (liangfei0201@163.com)
 * 
 * @version 1.0
 * 
 */
public interface Block {
	
	/**
	 * @return Block - 返回TurnNext的下一Block状态
	 */
	public Block getNextBolck();
	
	/**
	 * @return Block - 返回TurnPrevious的上一Block状态
	 */
	public Block getPreviousBolck();
	
	/**
	 * @return Block - 返回Block指定索引的Box
	 * 
	 * 如果遍历,请使用BlockIterator读取
	 * 
	 * @see @link iterator()
	 */
	public Box getBox(int index);
	
	/**
	 * @return int - 返回Block所包含Box的个数
	 */
	public int getBlockSize();
	
	/**
	 * @return BlockIterator - 返回Block迭代器，用于遍历Block所包含的Box
	 * 
	 * @see @link BlockIterator
	 */
	public BlockIterator iterator();
	
}
