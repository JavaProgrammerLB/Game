package liangfei.game.russiablock.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import liangfei.game.russiablock.controller.listener.BlockListener;
import liangfei.game.russiablock.controller.listener.BlockSubject;
import liangfei.game.russiablock.domain.Block;
import liangfei.game.russiablock.model.provider.BlockProvider;

public class Preview implements BlockProvider, BlockSubject {
	
	private BlockProvider blockProvider = null;
	
	private Block block;
	
	public Preview(BlockProvider blockProvider) {
		this.blockProvider = blockProvider;
	}

	@Override
	public Block getNextBlock() {
		Block oldBlock = block;
		if (oldBlock == null) {
			oldBlock = blockProvider.getNextBlock();
		}
		block = blockProvider.getNextBlock();
		firePreviewChanged();
		return oldBlock;
	}

	// 观察者 --------------
	
	private Set blockListenerSet = new HashSet();

	@Override
	public void addBlockListener(BlockListener blockListener) {
		blockListenerSet.add(blockListener);
	}

	@Override
	public void removeBlockListener(BlockListener blockListener) {
		blockListenerSet.remove(blockListener);
	}
	
	private void firePreviewChanged() {
		if (blockListenerSet != null && ! blockListenerSet.isEmpty()) {
			for (Iterator iterator = blockListenerSet.iterator(); iterator.hasNext(); ) {
				BlockListener listener = (BlockListener)iterator.next();
				listener.blockChanged(block);
			}
		}
	}
}
