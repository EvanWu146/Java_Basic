package menuTest;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.util.ArrayList;

public class MenuJFrame extends JFrame implements ActionListener{
	public newFilter filter = new newFilter("test");
	int[] chosenFlag = {0,0,0,0,0};
	String[] fileType = {"txt","docx","exe","jpg","*"};
	
	public static void main(String[] args) {
		new MenuJFrame("一个含菜单的应用程序");
	}
	
	public MenuJFrame(String s) {
		JFrame jf = new JFrame(s);
		jf.setSize(300,300);// 设置窗口的宽度和高度
		jf.setLocationRelativeTo(null);//设置窗口打开时的位置，null为默认屏幕中心
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗口点击关闭后的默认操作，此处设为退出进程
		
		JMenuBar menubar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu typeMenu = new JMenu("Type");
		
		JMenuItem itm1 = new JMenuItem("打开");	fileMenu.add(itm1); itm1.addActionListener(this);
		JMenuItem itm2 = new JMenuItem("退出");	fileMenu.add(itm2);	itm2.addActionListener(this);
		JCheckBox[] jc = new JCheckBox[5];
		for(int i = 0; i < 5; i++) {
			jc[i] = new JCheckBox(fileType[i]); 
			typeMenu.add(jc[i]);	
			jc[i].addActionListener(this);
		}
		
		menubar.add(typeMenu);
		menubar.add(fileMenu);

		JPanel panel = new JPanel();
		panel.add(menubar);
		jf.setJMenuBar(menubar);
		jf.setContentPane(panel);
		jf.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		
		if(label.equals("打开")) {
			JFileChooser chooser = new JFileChooser();// 创建一个默认打开用户文件夹的文件选择器
			chooser.addChoosableFileFilter(filter);
			chooser.showOpenDialog(this);
			chooser.setAcceptAllFileFilterUsed(true);
		}
		else if(label.equals("退出")) {
			System.exit(1);
		}
		else if(label.matches("txt|jpg|exe|docx|\\*")) {
			for(int i = 0; i < 5; i++) {
				if(label.equals(fileType[i])) {
					if(chosenFlag[i] == 0) {
						chosenFlag[i] = 1;
						filter.addExtension(label);
					}else if(chosenFlag[i] == 1) {
						chosenFlag[i] = 0;
						filter.removeExtension(label);
					}
					break;
				}
			}
		}
	}
}

class newFilter extends FileFilter{
	public String fileType = "";
	private String description = "";
	private ArrayList<String> extensions=new ArrayList<>();

	public void addExtension(String extension) {//增加筛选文件类型
		extensions.add(extension);
	}
	
	public void removeExtension(String s) {//删除筛选文件类型
		int i = 0;
		for(String str:extensions) {
			if(s.equals(extensions.get(i))) {
				extensions.remove(i--);	
				break;
			}
			i++;
		}
	}
	
	public boolean accept(File file) {
		if(file.isDirectory()) {
			return true;
		}
		for(String extension:extensions) {//有显示所有文件的选项,则返回true
			if(extension.equals("*")) return true;
		}
		String name=file.getName().toLowerCase();
		for(String extension:extensions) {
			if(name.endsWith(extension)||extension.equals("*")) return true;
		}
		return false;//其它的文件类型都设置为不可选
	}
	
	public newFilter(String s) {
		this.description = s;
	}
	
	public String getDescription() {
		return this.description;
	}
}
