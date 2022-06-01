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
		new MenuJFrame("һ�����˵���Ӧ�ó���");
	}
	
	public MenuJFrame(String s) {
		JFrame jf = new JFrame(s);
		jf.setSize(300,300);// ���ô��ڵĿ�Ⱥ͸߶�
		jf.setLocationRelativeTo(null);//���ô��ڴ�ʱ��λ�ã�nullΪĬ����Ļ����
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//���ô��ڵ���رպ��Ĭ�ϲ������˴���Ϊ�˳�����
		
		JMenuBar menubar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu typeMenu = new JMenu("Type");
		
		JMenuItem itm1 = new JMenuItem("��");	fileMenu.add(itm1); itm1.addActionListener(this);
		JMenuItem itm2 = new JMenuItem("�˳�");	fileMenu.add(itm2);	itm2.addActionListener(this);
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
		
		if(label.equals("��")) {
			JFileChooser chooser = new JFileChooser();// ����һ��Ĭ�ϴ��û��ļ��е��ļ�ѡ����
			chooser.addChoosableFileFilter(filter);
			chooser.showOpenDialog(this);
			chooser.setAcceptAllFileFilterUsed(true);
		}
		else if(label.equals("�˳�")) {
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

	public void addExtension(String extension) {//����ɸѡ�ļ�����
		extensions.add(extension);
	}
	
	public void removeExtension(String s) {//ɾ��ɸѡ�ļ�����
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
		for(String extension:extensions) {//����ʾ�����ļ���ѡ��,�򷵻�true
			if(extension.equals("*")) return true;
		}
		String name=file.getName().toLowerCase();
		for(String extension:extensions) {
			if(name.endsWith(extension)||extension.equals("*")) return true;
		}
		return false;//�������ļ����Ͷ�����Ϊ����ѡ
	}
	
	public newFilter(String s) {
		this.description = s;
	}
	
	public String getDescription() {
		return this.description;
	}
}
