package liangfei.game.russiablock.view.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class GameFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public GameFrame() {
		super("圣诞俄罗斯 -- JAvatar 梁飞 liangfei0201@163.com");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension fra = this.getSize();
		this.setLocation((scr.width - fra.width) / 2,
				(scr.height - fra.height) / 2);// 在屏幕居中显示
		this.getRootPane().setFocusable(true);
		this.getRootPane().setFocusCycleRoot(true);
		this.getContentPane().setBackground(Color.decode("#6E9EA2"));
		this.getContentPane().setLayout(null);
	}

}
