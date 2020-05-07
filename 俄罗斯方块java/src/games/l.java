package games;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class l extends JFrame {
	
	public l () {
		e panel = new e ();
		addKeyListener(panel);
		add(panel);
	}
	
	public static void main(String[] args) {
		l frame = new l ();
		frame.setLocationRelativeTo(null); // 居中		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击关闭按钮，退出程序
		frame.setSize(270, 330);//设置窗体大小（高度和宽度）
		frame.setTitle("俄罗斯方块");//设置窗体标题
		//菜单栏
		JMenuBar menuBar = new JMenuBar();
		JMenu help = new JMenu("帮助");
		JMenuItem about = help.add("关于");
		
		menuBar.add(help);
		
		about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "控制方向：left down right;变形：up");				
			}
		});
		frame.setJMenuBar(menuBar);
		//菜单栏
		frame.setVisible(true);//让窗体显示出来
		frame.setResizable(false);//不能调整窗口大小
	}
	
}


