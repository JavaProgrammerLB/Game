package liangfei.game.russiablock.model.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import liangfei.game.russiablock.domain.Block;
import liangfei.game.russiablock.util.RandomGenerator;

public class RandomProvider implements BlockProvider {
	
	private List blockList;
	
	public RandomProvider(Collection blocks) {
		 blockList = new ArrayList(blocks);
	}

	@Override
	public Block getNextBlock() {
		int style = RandomGenerator.getRandomGenerator().randomByMax(blockList.size());
		return (Block)blockList.get(style);
	}

}
