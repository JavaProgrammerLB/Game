package liangfei.game.russiablock.view.component.count;

import liangfei.game.russiablock.controller.listener.SpeedSubject;
import liangfei.game.russiablock.controller.listener.SpeedListener;

public class SpeedPanel extends CountPanel implements SpeedListener {
	
	private static final long serialVersionUID = 1L;

	private SpeedSubject speedSubject;
	
	public void setSpeedSubject(SpeedSubject speedSubject) {
		if (this.speedSubject != null) {
			this.speedSubject.removeSpeedListener(this);
		}
		if (speedSubject != null) {
			speedSubject.addSpeedListener(this);
		}
		this.speedSubject = speedSubject;
	}
	
	public void speedChanged(int speed) {
		super.setCount(speed);
	}

}
