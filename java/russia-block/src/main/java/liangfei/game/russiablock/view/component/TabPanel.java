package liangfei.game.russiablock.view.component;

import java.awt.Graphics;

import javax.swing.JPanel;

public class TabPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private char[] tabChars;
	
	public TabPanel(String tabText) {
		this.tabChars = tabText.toCharArray();
		this.setOpaque(false);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int w = super.getWidth();
		int h = super.getHeight();
		
		// 填充多边形 -------
		g.setColor(super.getBackground());
		int[] xs = {0,0,w,w};
		int[] ys = {w,h,h,0};
		g.fillPolygon(xs, ys, 4);
		
		// 画多边形外框 -------
		g.setColor(super.getBackground().darker());
		int[] xs1 = {1, 1, w - 1, w - 1};
		int[] ys1 = {w + 1, h - 2, h - 2, 3};
		g.drawPolygon(xs1, ys1, 4);
		
		// 画多边形内框 -------
		g.setColor(super.getBackground().brighter());
		int[] xs2 = {2, 2, w - 2, w - 2};
		int[] ys2 = {w + 2, h - 3, h - 3, 6};
		g.drawPolygon(xs2, ys2, 4);
		
		
		// 画字符 -------
		g.setColor(super.getForeground());
		//Font font = new Font("宋体", Font.BOLD, 16);
		//g.setFont(font);
		int ofsetH = g.getFontMetrics().getHeight();
		int ofsetX = (w - ofsetH) / 2 + 5;
		int ofsetY = ((h - w - ofsetH * tabChars.length) / 2) + w + 10;
		for (int i = 0; i < tabChars.length; i ++) {
			char[] drawChar = {tabChars[i]};
			g.drawChars(drawChar, 0, 1, ofsetX, ofsetY);
			ofsetY += ofsetH;
		}
		
		g.finalize();
	}
}
