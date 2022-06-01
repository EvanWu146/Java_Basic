package jComboBoxTest;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.RuntimeException;

public class Main {
	public static void main(String[] args) {
		JFrame jf = new JFrame("JcomboBox Test");
		jf.setSize(300,300);// 设置窗口的宽度和高度
		jf.setLocationRelativeTo(null);//设置窗口打开时的位置，null为默认屏幕中心
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗口点击关闭后的默认操作，此处设为退出进程
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Silly Man!");
		label.setFont(new Font(null, Font.PLAIN, 5));
		panel.add(label);
		
		String[] fontSize = new String[] {"5","10","20","30","40"};
		final JComboBox<String> comboBox = new JComboBox<String>(fontSize);
		JTextField text = new JTextField("5");
		
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					try {
						int size = Integer.parseInt(comboBox.getSelectedItem().toString());
						label.setFont(new Font(null, Font.PLAIN, size));
					}catch(NumberFormatException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		
		text.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				try {
					int size = Integer.parseInt(text.getText());
					label.setFont(new Font(null, Font.PLAIN, size));
				}catch(NumberFormatException ex) {
					ex.printStackTrace();
				}
			}
		});
		
		comboBox.setSelectedItem(0);
		panel.add(text);
		panel.add(comboBox);
		jf.setContentPane(panel);
		jf.setVisible(true);
	}
}

