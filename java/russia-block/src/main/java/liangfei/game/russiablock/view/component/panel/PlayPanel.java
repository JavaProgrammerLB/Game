package liangfei.game.russiablock.view.component.panel;

import javax.swing.JPanel;

import liangfei.game.russiablock.controller.facade.SubjectFacade;

public class PlayPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private PreviewPanel previewPanel;
	
	private BoardPanel boardPanel;
	
	public PlayPanel(SubjectFacade subjectFacade) {
		this.setOpaque(false);
		this.setSize(337, 542);
		this.setLayout(null);
		
		previewPanel = new PreviewPanel(subjectFacade);
		previewPanel.setLocation(0, 0);
		this.add(previewPanel);
		
		boardPanel = new BoardPanel(subjectFacade);
		boardPanel.setLocation(125, 0);
		this.add(boardPanel);
	}

}
