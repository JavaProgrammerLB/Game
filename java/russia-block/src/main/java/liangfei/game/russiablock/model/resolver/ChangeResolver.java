package liangfei.game.russiablock.model.resolver;

import liangfei.game.russiablock.domain.Block;
import liangfei.game.russiablock.domain.Location;

public interface ChangeResolver {
	
	public boolean canChangeTo(Block block, Location location);
	
	// 放在这不合适 ---
	public void addBlock(Block block, Location location);
	
}
