package liangfei.game.russiablock.view.component.count;

import java.util.Set;

import liangfei.game.russiablock.controller.listener.RemoveRowsListener;
import liangfei.game.russiablock.controller.listener.RemoveRowsSubject;

public class ScorePanel extends CountPanel implements RemoveRowsListener {

	private static final long serialVersionUID = 1L;
	
	private int[] levels = {1, 3, 7, 13};
	
	private int totalScore;

	private RemoveRowsSubject removeRowsSubject;
	
	public void setRemoveRowsSubject(RemoveRowsSubject removeRowsSubject) {
		if (this.removeRowsSubject != null) {
			this.removeRowsSubject.removeRemoveRowsListener(this);
		}
		if (removeRowsSubject != null) {
			removeRowsSubject.addRemoveRowsListener(this);
		}
		this.removeRowsSubject = removeRowsSubject;
	}
	
	public void rowsRemoved(Set removeRows) {
		int level = removeRows.size() - 1;
		if (level >= 0 && level < levels.length) {
			totalScore += levels[level];
		}
		super.setCount(totalScore);
	}

}
