package liangfei.game.russiablock.view.component.panel;

import javax.swing.JPanel;

import liangfei.game.russiablock.controller.facade.SubjectFacade;
import liangfei.game.russiablock.view.component.TabPanel;
import liangfei.game.russiablock.view.component.canvas.BlockCanvas;
import liangfei.game.russiablock.view.component.canvas.TurnBlockCanvas;
import liangfei.game.russiablock.view.decorator.box.GrayColorBoxDecorator;

public class PreviewPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private TabPanel turnTab, nextTab;

	private BlockCanvas turnBlockCanvas, nextBlockCanvas, alterBlockCanvas;

	public PreviewPanel(SubjectFacade subjectFacade) {
		this.setOpaque(false);
		this.setSize(125,269);
		this.setLayout(null);

		turnTab = new TabPanel("镜像");
		turnTab.setSize(37, 88);
		turnTab.setLocation(0, 0);
		this.add(turnTab);

		nextTab = new TabPanel("方块预览");
		nextTab.setSize(37, 177);
		nextTab.setLocation(0, 90);
		this.add(nextTab);

		turnBlockCanvas = new TurnBlockCanvas(new GrayColorBoxDecorator());
		turnBlockCanvas.setBlockSubject(subjectFacade.getPlayBlockSubject());
		turnBlockCanvas.setSize(88, 88);
		turnBlockCanvas.setLocation(37, 0);
		this.add(turnBlockCanvas);

		nextBlockCanvas = new BlockCanvas();
		nextBlockCanvas.setBlockSubject(subjectFacade.getNextBlockSubject());
		nextBlockCanvas.setSize(88, 88);
		nextBlockCanvas.setLocation(37, 90);
		this.add(nextBlockCanvas);

		alterBlockCanvas = new BlockCanvas(new GrayColorBoxDecorator());
		alterBlockCanvas.setBlockSubject(subjectFacade.getAfterBlockSubject());
		alterBlockCanvas.setSize(88, 88);
		alterBlockCanvas.setLocation(37, 179);
		this.add(alterBlockCanvas);
	}
}
