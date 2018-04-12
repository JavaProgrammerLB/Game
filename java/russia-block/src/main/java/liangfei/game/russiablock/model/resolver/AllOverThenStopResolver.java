package liangfei.game.russiablock.model.resolver;

import java.util.List;

public class AllOverThenStopResolver implements StopResolver {

	@Override
	public boolean isStop(List overStates) {
		for (int i = 0; i < overStates.size(); i ++) {
			Boolean isOver = (Boolean)overStates.get(i);
			if (! isOver.booleanValue()) {
				return false;
			}
		}
		return true;
	}

}
