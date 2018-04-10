package liangfei.game.russiablock.domain;


/**
 * 
 * 由多个(默认为24*12个)Box组成的矩形面板
 * 
 * @author 梁飞 liangfei0201@163.com
 *
 */
public interface Board {
	
	public Box getBox(int row, int col);
	
	public int getBoardRows();
	
	public int getBoardCols();
	
	public int getBlankRows();
}
