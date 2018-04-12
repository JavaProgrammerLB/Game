package liangfei.game.russiablock.view.component.count;

import java.util.Set;

import liangfei.game.russiablock.controller.listener.RemoveRowsListener;
import liangfei.game.russiablock.controller.listener.RemoveRowsSubject;

public class RemoveRowsPanel extends CountPanel implements RemoveRowsListener {

	private static final long serialVersionUID = 1L;
	
	private int totalRemoveRows;
	
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

	@Override
	public void rowsRemoved(Set removeRows) {
		totalRemoveRows += removeRows.size();
		super.setCount(totalRemoveRows);
	}

}
