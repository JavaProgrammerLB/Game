package liangfei.game.russiablock.model.resolver;

import java.util.List;

public class AllReadyThenStartResolver implements StartResolver {

	@Override
	public boolean isStart(List readyStates) {
		for (int i = 0; i < readyStates.size(); i ++) {
			Boolean isReady = (Boolean)readyStates.get(i);
			if (! isReady.booleanValue()) {
				return false;
			}
		}
		return true;
	}

}
