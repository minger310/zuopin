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
		frame.setLocationRelativeTo(null); // ����		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����رհ�ť���˳�����
		frame.setSize(270, 330);//���ô����С���߶ȺͿ�ȣ�
		frame.setTitle("����˹����");//���ô������
		//�˵���
		JMenuBar menuBar = new JMenuBar();
		JMenu help = new JMenu("����");
		JMenuItem about = help.add("����");
		
		menuBar.add(help);
		
		about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "���Ʒ���left down right;���Σ�up");				
			}
		});
		frame.setJMenuBar(menuBar);
		//�˵���
		frame.setVisible(true);//�ô�����ʾ����
		frame.setResizable(false);//���ܵ������ڴ�С
	}
	
}


