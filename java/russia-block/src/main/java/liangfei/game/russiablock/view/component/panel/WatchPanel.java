package liangfei.game.russiablock.view.component.panel;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import liangfei.game.russiablock.controller.facade.SubjectFacade;
import liangfei.game.russiablock.view.component.canvas.BoardCanvas;
import liangfei.game.russiablock.view.component.count.DelayPanel;
import liangfei.game.russiablock.view.component.count.SpeedPanel;

public class WatchPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private MemberPanel memberPanel;

	private SpeedPanel speedPanel;

	private DelayPanel delayPanel;

	private BoardCanvas boardCanvas;

	public WatchPanel(SubjectFacade subjectFacade) {
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.setSize(116, 267);
		this.setLayout(null);

		memberPanel = new MemberPanel();
		memberPanel.setSize(96, 30);
		memberPanel.setLocation(10, 10);
		this.add(memberPanel);

		speedPanel = new SpeedPanel();
		speedPanel.setSpeedSubject(subjectFacade.getSpeedSubject());
		speedPanel.setTextPattern("{0}级");
		speedPanel.setSize(43, 18);
		speedPanel.setLocation(10, 43);
		this.add(speedPanel);

		delayPanel = new DelayPanel();
		delayPanel.setTextPattern("{0}ms");
		delayPanel.setSize(43, 18);
		delayPanel.setLocation(63, 43);
		this.add(delayPanel);

		boardCanvas = new BoardCanvas();
		boardCanvas.setBoardSubject(subjectFacade.getPlayBoardSubject());
		boardCanvas.setBoxSize(8);
		boardCanvas.setLocation(10, 64);
		this.add(boardCanvas);
	}

}
