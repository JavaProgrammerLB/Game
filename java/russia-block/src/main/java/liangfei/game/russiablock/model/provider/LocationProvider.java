package liangfei.game.russiablock.model.provider;

import liangfei.game.russiablock.domain.Block;
import liangfei.game.russiablock.domain.Location;

public interface LocationProvider {
	
	public Location getBeginLocation(Block block);
	
}
