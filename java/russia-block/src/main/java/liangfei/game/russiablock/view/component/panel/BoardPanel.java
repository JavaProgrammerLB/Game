package liangfei.game.russiablock.view.component.panel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import liangfei.game.russiablock.controller.facade.SubjectFacade;
import liangfei.game.russiablock.view.component.canvas.PlayCanvas;
import liangfei.game.russiablock.view.component.count.DelayPanel;
import liangfei.game.russiablock.view.component.count.RemoveRowsPanel;
import liangfei.game.russiablock.view.component.count.ScorePanel;
import liangfei.game.russiablock.view.component.count.SpeedPanel;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private MemberPanel memberPanel;

	private SpeedPanel speedPanel;

	private DelayPanel delayPanel;

	private RemoveRowsPanel removeRowsPanel;

	private ScorePanel scorePanel;

	private PlayCanvas playCanvas;
	
	private JLabel magicBoxLabel;
	
	private MagicBoxPanel magicBoxPanel;
	
	private JLabel descriptionLabel;

	public BoardPanel(SubjectFacade subjectFacade) {
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.setSize(212, 542);
		this.setLayout(null);

		memberPanel = new MemberPanel();
		memberPanel.setSize(192, 50);
		memberPanel.setLocation(10, 10);
		this.add(memberPanel);

		speedPanel = new SpeedPanel();
		speedPanel.setSpeedSubject(subjectFacade.getSpeedSubject());
		speedPanel.setTextPattern("速度:{0}级");
		speedPanel.setSize(90, 20);
		speedPanel.setLocation(10, 70);
		this.add(speedPanel);

		delayPanel = new DelayPanel();
		delayPanel.setForeground(Color.white);
		delayPanel.setTextPattern("网络延迟:{0}ms");
		delayPanel.setSize(90, 20);
		delayPanel.setLocation(112, 70);
		this.add(delayPanel);

		removeRowsPanel = new RemoveRowsPanel();
		removeRowsPanel.setRemoveRowsSubject(subjectFacade
				.getRemoveRowsSubject());
		removeRowsPanel.setTextPattern("消除:{0}行");
		removeRowsPanel.setSize(90, 20);
		removeRowsPanel.setLocation(112, 70);
		// this.add(removeRowsPanel);

		scorePanel = new ScorePanel();
		scorePanel.setRemoveRowsSubject(subjectFacade.getRemoveRowsSubject());
		scorePanel.setTextPattern("得分:{0}");
		scorePanel.setSize(90, 20);
		scorePanel.setLocation(112, 70);
		// this.add(scorePanel);

		playCanvas = new PlayCanvas();
		playCanvas.setBoardSubject(subjectFacade.getPlayBoardSubject());
		playCanvas.setBlockSubject(subjectFacade.getPlayBlockSubject());
		playCanvas
				.setLocationSubject(subjectFacade.getPlayLocationSubject());
		playCanvas.setBoxSize(16);
		playCanvas.setLocation(10, 100);
		this.add(playCanvas);
		
		magicBoxLabel = new JLabel("我的道具:");
		magicBoxLabel.setForeground(Color.WHITE);
		magicBoxLabel.setSize(16 * 12, 16);
		magicBoxLabel.setLocation(10, 16 * 24 + 102);
		this.add(magicBoxLabel);
		
		magicBoxPanel = new MagicBoxPanel();
		magicBoxPanel.setLocation(10, 16 * 24 + 120);
		this.add(magicBoxPanel);
		
		descriptionLabel = new JLabel();
		descriptionLabel.setForeground(Color.WHITE);
		descriptionLabel.setSize(16 * 12, 16);
		descriptionLabel.setLocation(10, 16 * 24 + 140);
		this.add(descriptionLabel);
		
	}

}
