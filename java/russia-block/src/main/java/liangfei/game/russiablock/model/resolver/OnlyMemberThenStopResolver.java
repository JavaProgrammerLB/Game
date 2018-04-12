package liangfei.game.russiablock.model.resolver;

import java.util.List;

public class OnlyMemberThenStopResolver implements StopResolver {

	@Override
	public boolean isStop(List overStates) {
		int lives = 0;
		for (int i = 0; i < overStates.size(); i ++) {
			Boolean isOver = (Boolean)overStates.get(i);
			if (! isOver.booleanValue()) {
				lives ++;
			}
			if (lives > 1) {
				return false;
			}
		}
		return true;
	}

}
