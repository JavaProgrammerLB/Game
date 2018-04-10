package liangfei.game.russiablock.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import liangfei.game.russiablock.controller.command.BoardCommandReceiver;
import liangfei.game.russiablock.controller.listener.BoardSubject;
import liangfei.game.russiablock.controller.listener.OverListener;
import liangfei.game.russiablock.controller.listener.OverSubject;
import liangfei.game.russiablock.controller.listener.RemoveRowsListener;
import liangfei.game.russiablock.controller.listener.BoardListener;
import liangfei.game.russiablock.controller.listener.RemoveRowsSubject;
import liangfei.game.russiablock.domain.Block;
import liangfei.game.russiablock.domain.BlockIterator;
import liangfei.game.russiablock.domain.Board;
import liangfei.game.russiablock.domain.Box;
import liangfei.game.russiablock.domain.Location;
import liangfei.game.russiablock.model.provider.LocationProvider;
import liangfei.game.russiablock.model.resolver.ChangeResolver;
import liangfei.game.russiablock.util.IntegerSortSet;

/**
 * 与Board相关操作的实现类
 * @author 梁飞 liangfei0201@163.com
 *
 */
public class BoardContext implements Board, BoardSubject, BoardCommandReceiver, RemoveRowsSubject, OverSubject, LocationProvider, ChangeResolver {
	
	private int boardRows;
	
	private int boardCols;
	
	private Box[][] boxes;
	
	// 画板的空白行数
	// blankRows以上的可以直接填充BackColor
	// 如果blankRows小于0，则判输
	private int blankRows;
	
	public BoardContext(int rows, int cols) {
		boardRows = rows;
		boardCols = cols;
		boxes = new Box[boardRows][boardCols];
		blankRows = rows;
	}

	// ---------------------------------------------
	// --------------- 画板状态 ----------------------
	// ---------------------------------------------
	
	public Box getBox(int row, int col) {
		if (row >= 0 && row < getBoardRows()
				&& col >= 0 && col < getBoardCols()) {
			return boxes[row][col];
		}
		return null;
	}
	
	public int getBoardRows() {
		return boardRows;
	}
	
	public int getBoardCols() {
		return boardCols;
	}
	
	public int getBlankRows() {
		return blankRows;
	}
	
	private void setBlankRows(int blankRows) {
		if (blankRows >= 0 && blankRows <= getBoardRows()) {
			this.blankRows = blankRows;
		}
		if (this.blankRows == 0) {
			fireGameOvered();
		}
	}
	
	// ---------------------------------------------
	// --------------- 画板行为 ----------------------
	// ---------------------------------------------
	
	// 命令接收 ----------
	
	public void clearBoard() {
		boxes = new Box[boardRows][boardCols];
		fireBoardChanged();
	}
	
	private boolean isEven = false;
	
	public void addRows(int rows) {
		int bottomRow = getBoardRows() - 1;
		for (int i = 0; i < rows; i++) {
			addLine(bottomRow, isEven);
			isEven = (! isEven);
		}
		fireBoardChanged();
	}
	
	public void removeRows(int rows) {
		int bottomRow = getBoardRows() - 1;
		for (int i = 0; i < rows; i++) {
			removeLine(bottomRow);
			isEven = (! isEven);
		}
		fireBoardChanged();
	}
	
	// LocationProvider -----------
	
	public Location getBeginLocation(Block block) {
		Location location = new Location(2, getBoardCols() / 2 - 1);
		return upLocation(block, location);
	}
	
	// ChangeResolver -----------
	
	public boolean canChangeTo(Block block, Location location) {
		if (block == null || location == null) {
			return false;
		}
		for (BlockIterator i = block.iterator(); i.hasNextBox(); ) {
			Box box = i.nextBox();
			int col = location.getCol() + box.getOffsetCol();
			if (col < 0 || col >= getBoardCols()) {
				return false;
			}
			int row = location.getRow() + box.getOffsetRow();
			if (row >= getBoardRows()) { // 允许row小于0
				return false;
			}
			if (row >= 0 && boxes[row][col] != null) {
				return false;
			}
		}
		return true;
	}
	
	public synchronized void addBlock(Block block, Location location) {
		location = upLocation(block, location);
		Set effectRows = new IntegerSortSet();
		for (BlockIterator i = block.iterator(); i.hasNextBox(); ) {
			Box box = i.nextBox();
			int col = location.getCol() + box.getOffsetCol();
			if (col < 0 || col >= getBoardCols()) {
				throw new RuntimeException("Col:" + col + " 出界!");
			}
			int row = location.getRow() + box.getOffsetRow();
			if (row >= getBoardRows()) { // 允许row小于0
				throw new RuntimeException("Row:" + row + " 出界!");
			}
			if (row >= 0) {
				if (boxes[row][col] != null) {
					throw new RuntimeException("(" + row + "," + col + ") 位置已经有Box,并入Block冲突!");
				}
				boxes[row][col] = box;
				effectRows.add(new Integer(row));
				if (blankRows > row) {
					setBlankRows(row);
				}
			}
		}
		if (! effectRows.isEmpty()) {
			removeFullLine(effectRows);
			fireBoardChanged();
		}
	}
	
	// MagicBox 处理 -----
	
	private List magics = new LinkedList();
	
	public boolean hasMagic(int magic) {
		return magics.contains(new Integer(magic));
	}
	
	public void popMagic(int magic) {
		magics.remove(new Integer(magic));
	}
	
	// 私有逻辑 ----------
	
	private Location upLocation(Block block, Location location) {
		while (! canChangeTo(block, location)) {
			System.out.println("up");
			location = location.getUpLocation();
			if (location.getRow() < -2) {
				fireGameOvered();
				return null;
			}
		}
		return location;
	}
	
	private void removeFullLine(Set effectRows) {
		Set removeRows = new IntegerSortSet();
		for (Iterator i = effectRows.iterator(); i.hasNext(); ) {
			Integer rowInteger = (Integer)i.next();
			int row = rowInteger.intValue();
			if (isFullLine(row)) {
				removeLine(row);
				removeRows.add(rowInteger);
			} else {
				//i.remove();
			}
		}
		if (removeRows != null && ! removeRows.isEmpty()) {
			fireRowsRemoved(removeRows);
		}
	}
	
	private boolean isFullLine(int row) {
		for (int i = 0; i < getBoardCols(); i ++) {
			if (boxes[row][i] == null) {
				return false;
			}
		}
		return true;
	}
	
	private synchronized void addLine(int row, boolean isEven) {
		// 条件检查
		if (blankRows == 0) {
			return;
		}
		// 将row所在行及其以上行向上移动
		for (int i = blankRows; i <= row; i ++) {
			for (int j = 0; j < getBoardCols(); j ++) {
				boxes[i - 1][j] = boxes[i][j];
			}
		}
		// 根据isEven标记在row行间隔的加入Box
		for (int j = 0; j < getBoardCols(); j ++) {
			boolean isAdd = (j % 2 == 0);
			if (isEven) {
				isAdd = (! isAdd);
			}
			if (isAdd) {
				boxes[row][j] = new Box(0, 0, 0);
			} else {
				boxes[row][j] = null;
			}
		}
		// blankRows减少
		setBlankRows(blankRows - 1);
	}
	
	private synchronized void removeLine(int row) {
		// 条件检查
		if ((row == getBlankRows() - 1) && (blankRows == getBlankRows())) {
			return ;
		}
		// 检查MagicBox
		/*for (int j = 0; j < getBoardCols(); j ++) {
			Magic magic = boxes[row][j].getMagic();
			if (magic != null) {
				magics.add(magic);
			}
		}*/
		// 将row以上行向下移动
		for (int i = row; i > blankRows ; i --) {
			for (int j = 0; j < getBoardCols(); j ++) {
				boxes[i][j] = boxes[i - 1][j];
			}
		}
		// 清空最上面一行
		for (int j = 0; j < getBoardCols(); j ++) {
			boxes[blankRows][j] = null;
		}
		// blankRows增加
		setBlankRows(blankRows + 1);
	}
	
	// Board状态变化通知 (观察者模式) ---------
	
	private Set boardListenerSet = new HashSet();
	
	public void addBoardListener(BoardListener boardListener) {
		boardListenerSet.add(boardListener);
	}
	
	public void removeBoardListener(BoardListener boardListener) {
		boardListenerSet.remove(boardListener);
	}
	
	private void fireBoardChanged() {
		if (boardListenerSet != null && ! boardListenerSet.isEmpty()) {
			for (Iterator iterator = boardListenerSet.iterator(); iterator.hasNext(); ) {
				BoardListener listener = (BoardListener)iterator.next();
				listener.boardChanged(this);
			}
		}
	}
	
	// 移除行事件通知 (观察者模式)---
	
	private Set removeRowsListenerSet = new HashSet();
	
	public void addRemoveRowsListener(RemoveRowsListener removeRowsListener) {
		removeRowsListenerSet.add(removeRowsListener);
	}
	
	public void removeRemoveRowsListener(RemoveRowsListener removeRowsListener) {
		removeRowsListenerSet.remove(removeRowsListener);
	}
	
	private void fireRowsRemoved(Set removeRows) {
		if (removeRowsListenerSet != null && ! removeRowsListenerSet.isEmpty()) {
			for (Iterator iterator = removeRowsListenerSet.iterator(); iterator.hasNext(); ) {
				RemoveRowsListener listener = (RemoveRowsListener)iterator.next();
				listener.rowsRemoved(removeRows);
			}
		}
	}
	
	// 游戏结束通知 (观察者模式)---
	
	private Set overListenerSet = new HashSet();

	public void addOverListener(OverListener overListener) {
		overListenerSet.add(overListener);
	}

	public void removeOverListener(OverListener overListener) {
		overListenerSet.remove(overListener);
	}
	
	private void fireGameOvered() {
		if (overListenerSet != null && ! overListenerSet.isEmpty()) {
			for (Iterator iterator = overListenerSet.iterator(); iterator.hasNext(); ) {
				OverListener listener = (OverListener)iterator.next();
				listener.gameOvered();
			}
		}
	}

}
