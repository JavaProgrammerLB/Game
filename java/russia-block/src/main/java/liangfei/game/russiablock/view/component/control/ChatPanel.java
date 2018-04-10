package liangfei.game.russiablock.view.component.control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class ChatPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JScrollPane messagePanel;

	private JTextArea messageTextArea;

	private JComboBox phraseComboBox;

	private JTextField chatTextField;

	private JButton sendButton, cleanButton;

	public ChatPanel() {
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.setSize(180, 230);
		this.setLayout(null);

		messageTextArea = new JTextArea(5, 10);
		messageTextArea.setEditable(false);
		messageTextArea.setLineWrap(true);
		messageTextArea.setSize(150, 150);
		messagePanel = new JScrollPane();
		messagePanel.setAutoscrolls(true);
		messagePanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		messagePanel.getViewport().setBackground(Color.white);
		messagePanel.getViewport().setView(messageTextArea);
		messagePanel.setSize(160, 160);
		messagePanel.setLocation(10, 10);
		this.add(messagePanel);

		String[] phrase = { " --短语--", "快开啊！", "水平太烂了！", "你好厉害啊！" };
		phraseComboBox = new JComboBox(phrase);
		phraseComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.DESELECTED
						&& phraseComboBox.getSelectedIndex() > 0) {
					chatTextField.setText(chatTextField.getText()
							+ (String) phraseComboBox.getSelectedItem());
					chatTextField.requestFocus();
				}
				if (phraseComboBox.getSelectedIndex() > 0) {
					phraseComboBox.setSelectedIndex(0);
				}
			}
		});
		phraseComboBox.setSize(95, 20);
		phraseComboBox.setLocation(10, 175);
		this.add(phraseComboBox);

		cleanButton = new JButton("清屏");
		cleanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				messageTextArea.setText("");
				chatTextField.requestFocus();
			}
		});
		cleanButton.setSize(60, 20);
		cleanButton.setLocation(110, 175);
		this.add(cleanButton);

		chatTextField = new JTextField(10);
		chatTextField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				if (e.getKeyCode() == 10 || e.getKeyCode() == 13) {
					sendMessage();
				}
			}
		});
		chatTextField.setSize(95, 20);
		chatTextField.setLocation(10, 200);
		this.add(chatTextField);

		sendButton = new JButton("发言");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
		sendButton.setSize(60, 20);
		sendButton.setLocation(110, 200);
		this.add(sendButton);
	}
	
	private void sendMessage() {
		String message = chatTextField.getText();
		if (message != null && message.length() > 0) {
			messageTextArea.append(chatTextField.getText() + "\n");
			chatTextField.setText("");
		}
		chatTextField.requestFocus();
	}
}
