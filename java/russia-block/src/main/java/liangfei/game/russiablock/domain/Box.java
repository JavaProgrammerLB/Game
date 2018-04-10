package liangfei.game.russiablock.domain;


/**
 * 
 * 原子性方格，Block和Board的组成部分
 * @author 梁飞 liangfei
 *
 */

public class Box {
	
	// 此Box相对Location的偏移行数
	private int offsetRow;
	
	// 此Box相对Location的偏移列数
	private int offsetCol;
	
	// 此Box的绘制颜色
	private int style;
	
	private Magic magic;
	
	// 不变模式(Immutable)
	// 构造子注入参数，使其在创建后，不再可改
	public Box(int offsetRow, int offsetCol, int style){
		this.offsetRow = offsetRow;
		this.offsetCol = offsetCol;
		this.style = style;
	}
	
	public int getOffsetCol() {
		return offsetCol;
	}

	public int getOffsetRow() {
		return offsetRow;
	}
	
	public int getStyle() {
		return style;
	}

	public Magic getMagic() {
		return magic;
	}

	public void setMagic(Magic magic) {
		this.magic = magic;
	}
}
