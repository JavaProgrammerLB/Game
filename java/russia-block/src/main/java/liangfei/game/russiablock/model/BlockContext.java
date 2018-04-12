package liangfei.game.russiablock.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import liangfei.game.russiablock.controller.command.MoveCommandReceiver;
import liangfei.game.russiablock.controller.command.TurnCommandReceiver;
import liangfei.game.russiablock.controller.listener.BlockListener;
import liangfei.game.russiablock.controller.listener.LocationListener;
import liangfei.game.russiablock.controller.listener.BlockSubject;
import liangfei.game.russiablock.controller.listener.LocationSubject;
import liangfei.game.russiablock.domain.Block;
import liangfei.game.russiablock.domain.Location;
import liangfei.game.russiablock.model.provider.BlockProvider;
import liangfei.game.russiablock.model.provider.LocationProvider;
import liangfei.game.russiablock.model.resolver.ChangeResolver;

/**
 * 
 * Context 类为上下文类
 * 
 * @author 梁飞 (liangfei0201@163.com)
 * 
 * @version 1.0
 * 
 */
public class BlockContext implements BlockSubject, LocationSubject, TurnCommandReceiver, MoveCommandReceiver {
	
	// ---------------------------------------------
	// ----------- 下一Block的供给类  -----------
	// ---------------------------------------------
	
	private ChangeResolver changeResolver;
	
	private BlockProvider blockProvider;
	
	private LocationProvider locationProvider;
	
	// 构造子注入 (策略模式)
	// BlockProvider为策略接口
	
	public BlockContext(BlockProvider blockProvider, LocationProvider locationProvider, ChangeResolver changeResolver) {
		this.blockProvider = blockProvider;
		this.locationProvider = locationProvider;
		this.changeResolver = changeResolver;
	}
	
	// 游戏状态监听 -------------
	
	private boolean isStart;
	
	public void gameStarted() {
		isStart = true;
		begin();
	}
	
	public void gameStoped() {
		isStart = false;
	}
	
	// Context初始化 -------
	
	private boolean isBegin = true;
	
	private void begin() {
		if (! isStart) {
			return ;
		}
		isBegin = false; //锁定命令接收
		block = blockProvider.getNextBlock();
		fireBlockChanged();
		location = locationProvider.getBeginLocation(block);
		fireLocationChanged();
		isBegin = true; //打开命令接收
	}
	
	// ---------------------------------------------
	// ---------------- Block方向切换  ---------------
	// ---------------------------------------------
	
	// 当前运行的block
	private Block block;
	
	/*public Block getBlock() {
		return block;
	}*/
	
	// 切换动作 (状态模式)
	// Board为Context角色，Block为State接口，BaseBlock为具
	@Override
	public void turnNext() {
		if(block != null) {
			turnTo(block.getNextBolck());
		}
	}

	@Override
	public void turnPrevious() {
		if(block != null) {
			turnTo(block.getPreviousBolck());
		}
	}
	
	private void turnTo(Block toBlock) {
		if (! isStart || ! isBegin) {
			return ;
		}
		
		if (! block.equals(toBlock) && changeResolver.canChangeTo(toBlock, location)) {
			block = toBlock;
			fireBlockChanged();
		}
	}
	
	// ---------------------------------------------
	// --------------- Block位置移动 -----------------
	// ---------------------------------------------
	
	// 当前block的所在坐标
	private Location location;
	
	/*public Location getLocation() {
		return location;
	}*/
	
	// Move属于Canvas行为
	// Bolck没有Canvas是不具备Move行为的
	// 所以Move不应放在Bolck中
	@Override
	public void moveLeft() {
		if (location != null) {
			moveTo(location.getLeftLocation());
		}
	}

	@Override
	public void moveRight() {
		if (location != null) {
			moveTo(location.getRightLocation());
		}
	}

	@Override
	public void moveDown() {
		if (location != null) {
			moveTo(location.getDownLocation());
		}
	}

	@Override
	public void moveBottom() {
		if (location != null) {
			Location toLocation = location.getDownLocation();
			while (changeResolver.canChangeTo(block, toLocation)) {
				toLocation = toLocation.getDownLocation();
			}
			moveTo(toLocation.getUpLocation());
		}
	}
	
	private void moveTo(Location toLocation) {
		if (! isStart || ! isBegin) {
			return ;
		}
		
		if (! location.equals(toLocation) && changeResolver.canChangeTo(block, toLocation)) {
			location = toLocation;
			fireLocationChanged();
		}
		checkEnd();
	}
	
	private void checkEnd() {
		if (! changeResolver.canChangeTo(block, location.getDownLocation())) {
			changeResolver.addBlock(block, location);
			begin();
		}
	}
	
	// Block方向状态变化通知 (观察者模式)
	
	private Set blockListenerSet = new HashSet();

	@Override
	public void addBlockListener(BlockListener blockListener) {
		blockListenerSet.add(blockListener);
	}

	@Override
	public void removeBlockListener(BlockListener blockListener) {
		blockListenerSet.remove(blockListener);
	}
	
	private void fireBlockChanged() {
		if (blockListenerSet != null && ! blockListenerSet.isEmpty()) {
			for (Iterator iterator = blockListenerSet.iterator(); iterator.hasNext(); ) {
				BlockListener listener = (BlockListener)iterator.next();
				listener.blockChanged(block);
			}
		}
	}
	
	// Block位置状态变化通知 (观察者模式)
	
	private Set locationListenerSet = new HashSet();

	@Override
	public void addLocationListener(LocationListener locationListener) {
		locationListenerSet.add(locationListener);
	}

	@Override
	public void removeLocationListener(LocationListener locationListener) {
		locationListenerSet.remove(locationListener);
	}
	
	private void fireLocationChanged() {
		if (locationListenerSet != null && ! locationListenerSet.isEmpty()) {
			for (Iterator iterator = locationListenerSet.iterator(); iterator.hasNext(); ) {
				LocationListener listener = (LocationListener)iterator.next();
				listener.locationChanged(location);
			}
		}
	}
	
}
