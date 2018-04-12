package liangfei.game.russiablock.view.component.canvas;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import liangfei.game.russiablock.controller.listener.BoardListener;
import liangfei.game.russiablock.controller.listener.BoardSubject;
import liangfei.game.russiablock.domain.Board;
import liangfei.game.russiablock.domain.Box;
import liangfei.game.russiablock.view.decorator.box.BoxDecorator;
import liangfei.game.russiablock.view.decorator.box.MultiColorBoxDecorator;

public class BoardCanvas extends JPanel implements BoardListener {

	private static final long serialVersionUID = 1L;

	private int boxSize = 16;
	
	private BoardSubject boardSubject;
	
	private Board board;
	
	protected BoxDecorator boxDecorator;
	
	public BoardCanvas() {
		this(new MultiColorBoxDecorator());
	}
	
	public BoardCanvas(BoxDecorator boxDecorator) {
		this.boxDecorator = boxDecorator;
		super.setBackground(Color.BLACK);
	}
	
	public void setBoardSubject(BoardSubject boardSubject) {
		if (this.boardSubject != null) {
			this.boardSubject.removeBoardListener(this);
		}
		if (boardSubject != null) {
			boardSubject.addBoardListener(this);
		}
		this.boardSubject = boardSubject;
	}

	@Override
	public void boardChanged(Board board) {
		this.board = board;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (board != null) {
			int boardRows = board.getBoardRows();
			int boardCols = board.getBoardCols();
			int blankRows = board.getBlankRows();
			g.setColor(super.getBackground());
			g.fillRect(0, 0, getBoxSize() * boardCols, getBoxSize() * boardRows);
			for (int row = blankRows; row < boardRows; row++) {
				for (int col = 0; col < boardCols; col++) {
					Box box = board.getBox(row, col);
					if (box != null) {
						boxDecorator.drawBox(g, col * getBoxSize(), row * getBoxSize(), getBoxSize(), box.getStyle());
					}
				}
			}
		}
	}

	public int getBoxSize() {
		return boxSize;
	}

	public void setBoxSize(int boxSize) {
		this.boxSize = boxSize;
		super.setSize(boxSize * 12, boxSize * 24);
	}
}
