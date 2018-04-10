package liangfei.game.russiablock.view.decorator.frame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;

public class UIStyle {

	public static void setMyStyle() {
		// =======设置默认风格=========
		UIManager.put("Label.font", new Font("宋体", 0, 12));
		UIManager.put("TextField.font", new Font("宋体", 0, 12));
		UIManager.put("PasswordField.font", new Font("宋体", 0, 12));
		UIManager.put("TextArea.font", new Font("宋体", 0, 12));
		UIManager.put("ComboBox.font", new Font("宋体", 0, 12));
		UIManager.put("Button.font", new Font("宋体", 0, 12));
		UIManager.put("CheckBox.font", new Font("宋体", 0, 12));
		
		UIManager.put("ComboBox.background", Color.WHITE);
		UIManager.put("Button.background",Color.WHITE);
		UIManager.put("ScrollBar.background", Color.WHITE);
		UIManager.put("ScrollPane.background", Color.WHITE);
		
		UIManager.put("Panel.background", Color.decode("#376670"));
		UIManager.put("Panel.foreground", Color.WHITE);
		// UIManager.put("Panel.border", BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		// UIManager.put("Panel.layout", null);
		
		// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		// SwingUtilities.updateComponentTreeUI(this);
	}
}
