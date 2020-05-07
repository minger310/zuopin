package games;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * ����˹������Ϸ������
 * @author LXT
 *
 */
public class e extends JPanel implements KeyListener{
	
	e () {
		newBlock();
		newMap();
		drawWall();//���û�Χǽ����
		Timer timer = new Timer(1000, new TimeListener());
		timer.start();//������ʱ��
	}
	
	Random random = new Random();
	
	private int score = 0;
	private int delLineNum = 0;
	
	//���巽��ĳ�ʼ���ꣻ
	private int x;
	private int y;
	
	//shapes[0][1]
	private int blockType;//��������� = random.nextInt(7)
	private int turnState;//�������ת״̬ = random.nextInt(4)
	
	private int preBlockType = random.nextInt(7);
	private int preTurnState = random.nextInt(4);
	
	//���巽��Ĵ�С
	private int blockSize = 10;	
	
	//�����ͼ��С
	private int mapSizeX = 17;
	private int mapSizeY = 28;
	
	//�����ͼ
	int[][] map = new int[mapSizeX][mapSizeY];
	
	int i;
	int j;
	//��ͼ�е�ֵ 0��û��  1��������״ 2������Χǽ
	//������״
		private final static int shapes[][][] = new int[][][]{
	        // |��
			{
				{0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
			},
			// S��
			{
				{0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
				{0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			},
			// Z��
			{
				{1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			},
			// J��
			{
				{0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
				{1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			},
			// O��
			{
				{1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			},
			// L��
			{
				{1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
				{1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			},
			// T��
			{
				{1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			}
		};
		
		/**
		 * �����µ���״
		 */
		public void newBlock(){
			//��ǰ��״��Ԥ����״����
			blockType = preBlockType;
			turnState = preTurnState;
			
			//������
			preBlockType = random.nextInt(7);
			preTurnState = random.nextInt(4);
			
			//��ʼ��xy���꣨����ĳ���λ�ã�
			x = 6;
			y = 0;
			
			if (gameOver (x, y) == 0) {
				newMap();
				drawWall();
				JOptionPane.showMessageDialog(null, "GAME OVER!");
			}
		}
		
		/**
		 * ���Χǽ
		 */
		public void drawWall(){
			for(i = 0; i < mapSizeX - 1; i++){
				map[i][mapSizeY - 2] = 2;//�����ұߵ�Χǽ
			}
			
			for(j = 0; j < mapSizeY - 1; j++){
				map[0][j] = 2;//������ߵ�Χǽ
				map[mapSizeX - 2][j] = 2;//���Ƶ��µ�Χǽ
			}			
		}
		
		/**
		 * ��ʼ����ͼ
		 */
		public void newMap () {
			for (i = 0; i < mapSizeX - 1; i++){
				 for (j = 0; j < mapSizeY - 1; j++){
					 map[i][j] = 0;
				 }
			}
		}
		
		/**
		 * �ı䷽��
		 */
		public void turn () {
			int tempTurnState = turnState;
			//�����µķ������
			turnState = (turnState + 1) % 4;
			if (check (x,y,blockType, turnState) == 0) {
				turnState = tempTurnState;
			}
			repaint();
		}
		
		//����
		public void left () {
			if (check (x - 1, y, blockType, turnState) == 1) {
				x = x - 1;
			}
			repaint();
		}
		
		//����
		public void right () {
			if (check (x + 1, y, blockType, turnState) == 1) {
				x = x + 1;
			}
			repaint();
		}
		
		//�½�
		public void down () {
			delLineNum = 0;
			if (check (x, y + 1, blockType, turnState) == 1) {
				y = y + 1;
				delLine();
			}
			
			if (check (x, y + 1, blockType, turnState) == 0) {
				add(x, y, blockType, turnState);
				newBlock();
				delLine();
			}
			//�ƶ�����
			switch (delLineNum) {
			case 1:score += 10; break;
			case 2:score += 50; break;
			case 3:score += 100; break;
			case 4:score += 200; break;
			}
			repaint();
		}
		
		/**
		 * ���һ����״
		 * @param x
		 * @param y
		 * @param blockType
		 * @param turnState
		 */
		public void add (int x, int y, int blockType, int turnState) {
			int j = 0;
			for (int outer = 0; outer < 4; outer++) {
				for (int inner = 0; inner < 4; inner++) {
					if (map[x + inner + 1][y + outer] == 0) {
						map[x + inner + 1][y + outer] = shapes[blockType][turnState][j];
					}
					j++;
				}
			}
		}
		
		//����
		public void delLine () {
			int flag = 0;
			for(int y = 0; y < mapSizeY - 1; y++) {
				for(int x = 0; x < mapSizeX - 1; x++) {
					if(map[x][y] == 1) {
						flag = flag + 1;
						//�ж��Ƿ������һ��
						if(flag == mapSizeX - 3) {
							delLineNum++;
							for (int d = y; d > 0; d--) {
								for (int e = 0; e < mapSizeX - 2; e++) {
									map[e][d] = map[e][d - 1];
								}
							}
						}
					}
				}
				flag = 0;
			}
		}
		
		/**
		 * �ж��ǲ�����Ϸ����
		 * @param x
		 * @param y
		 * @return
		 */
		public int gameOver (int x , int y) {
			if (check (x, y, blockType, turnState) == 0) {
				return 0;
			}
			return 1;
		}
		
		/**
		 * �������Ƿ���Ч
		 * @param x
		 * @param y
		 * @param blockType
		 * @param turnState
		 * @return
		 */
		public int check (int x, int y, int blockType, int turnState) {
			
			for (int outer = 0; outer < 4; outer++) {
				for (int inner = 0; inner < 4; inner++) {
					boolean flag1 = shapes[blockType][turnState][outer * 4 + inner] == 1;
					boolean flag2 = map[x + inner + 1][y + outer] == 1;
					boolean flag3 = map[x + inner + 1][y + outer] == 2;
					if ((flag1 && flag2) || (flag1 && flag3)) {
						return 0;//����һ��    ��Ч
					}
				}
			}
			return 1;//��Ч
		}
		
		
		/**
		 * ��������
		 */
		@Override
		public void paintComponent (Graphics g){
			super.paintComponent(g);//����paintComponent����������һЩ����Ķ���
			g.setColor(Color.BLACK);
			//����״
			for (j = 0; j < 16; j++){
				if (shapes[blockType][turnState][j] == 1){
					int x1 = (j % 4 + x + 1) * blockSize;
					int y1 = (j / 4 + y) * blockSize;
					g.fillRect(x1, y1, blockSize, blockSize);
				}
			}
			
			//�̶�����
			for (j = 0; j < mapSizeY - 1; j++){
				for (i = 0; i < mapSizeX - 1; i++){
					//�ѹ̶��ķ���
					if (map[i][j] == 1){
						g.setColor(Color.BLACK);//����һ����ɫ����ɫ��
						g.fillRect(i * blockSize, j * blockSize, blockSize, blockSize);//���
					}
					
					if(map[i][j] == 2){
						g.drawRect(i * blockSize, j * blockSize, blockSize, blockSize);//����
					}
				}								
			}
			
			//��Ԥ��ͼ
			for (j = 0; j < 16; j++){
				if (shapes[preBlockType][preTurnState][j] == 1){
					int x1 = (j % 4 + 20) * blockSize;
					int y1 = (j / 4 + 1) * blockSize;
					g.fillRect(x1, y1, blockSize, blockSize);
				}
			}
			
			g.setColor(Color.BLUE);
			g.setFont(new Font ("����", Font.BOLD, 16));
			
			g.drawString("�÷֣�" + score, 170, 80);
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			switch (KeyCode) {
			case KeyEvent.VK_DOWN:
				//ִ���½�
				down();
				break;
			case KeyEvent.VK_UP:
				//ִ�б���
				turn();
				break;
			case KeyEvent.VK_RIGHT:
				//����
				right();
				break;
			case KeyEvent.VK_LEFT:
				//����
				left();
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		/**
		 * ��ʱ��    �Զ��½�
		 * @author LXT
		 *
		 */
		class TimeListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				//repaint();				
				down();
			}
			
		}
		
}

