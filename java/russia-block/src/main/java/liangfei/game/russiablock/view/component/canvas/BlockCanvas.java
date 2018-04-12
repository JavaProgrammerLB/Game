package liangfei.game.russiablock.view.component.canvas;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import liangfei.game.russiablock.controller.listener.BlockListener;
import liangfei.game.russiablock.controller.listener.BlockSubject;
import liangfei.game.russiablock.domain.Block;
import liangfei.game.russiablock.domain.BlockIterator;
import liangfei.game.russiablock.domain.Box;
import liangfei.game.russiablock.view.decorator.box.BoxDecorator;
import liangfei.game.russiablock.view.decorator.box.MultiColorBoxDecorator;

public class BlockCanvas extends JPanel implements BlockListener {

	private static final long serialVersionUID = 1L;
	
	protected BoxDecorator boxDecorator;
	
	public BlockCanvas() {
		this(new MultiColorBoxDecorator());
	}
	
	public BlockCanvas(BoxDecorator boxDecorator) {
		this.boxDecorator = boxDecorator;
		super.setBackground(Color.BLACK);
		super.setSize(16 * 4 + 24, 16 * 4 + 24);
	}
	
	// Box大小设置 ---
	
	private int boxSize = 16;
	
	public int getBoxSize() {
		return boxSize;
	}

	public void setBoxSize(int boxSize) {
		this.boxSize = boxSize;
	}

	// block 监听 ---
	
	private BlockSubject blockSubject;
	
	public void setBlockSubject(BlockSubject blockSubject) {
		if (this.blockSubject != null) {
			this.blockSubject.removeBlockListener(this);
		}
		if (blockSubject != null) {
			blockSubject.addBlockListener(this);
		}
		this.blockSubject = blockSubject;
	}
	
	private Block block;

	@Override
	public void blockChanged(Block block) {
		this.block = getBlock(block);
		repaint();
	}
	
	// 重绘 ---
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(super.getBackground());
		g.fillRect(0, 0, super.getWidth(), super.getHeight());
		if (block != null) {
			int blockSize = block.getBlockSize();
			int offsetLeft = offset(super.getWidth(), blockSize);
			int offsetTop = offset(super.getHeight(), blockSize);
			for (BlockIterator i = block.iterator(); i.hasNextBox();) {
				Box box = i.nextBox();
				int row = box.getOffsetRow() + 1;
				int col = box.getOffsetCol() + 1;
				boxDecorator.drawBox(g, col * boxSize + offsetLeft, row * boxSize + offsetTop, boxSize, box.getStyle());
			}
		}
	}
	
	private int offset(int len, int size) {
		int s =  size * getBoxSize();
		if (len > s) {
			return (len - s) / 2;
		}
		return 0;
	}
	
	// 模板方法,子类多态 ---
	
	protected Block getBlock(Block block) {
		return block;
	}
}
