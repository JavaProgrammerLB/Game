package liangfei.game.russiablock.view.component;

import liangfei.game.russiablock.controller.listener.BlockListener;
import liangfei.game.russiablock.controller.listener.BlockSubject;
import liangfei.game.russiablock.domain.Block;
import liangfei.game.russiablock.util.AudioPlayer;

public class TurnAudio implements BlockListener {
	
	private BlockSubject blockSubject;
	
	public TurnAudio() {
		
	}
	
	public void setBlockSubject(BlockSubject blockSubject) {
		if (this.blockSubject != null) {
			this.blockSubject.removeBlockListener(this);
		}
		if (blockSubject != null) {
			blockSubject.addBlockListener(this);
		}
		this.blockSubject = blockSubject;
	}

	public void blockChanged(Block block) {
		AudioPlayer.play("turn.wav");
	}

}
