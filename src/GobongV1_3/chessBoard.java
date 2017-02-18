package GobongV1_3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * ����̳���������Ϊ�˺���д�ػ�ʱ����
 * 
 * @author ����
 * 
 */
public class chessBoard extends JPanel {
	private static final long serialVersionUID = 1L;

	public static boolean state = false;

	// step��¼����
	// public static int step = 0;
	private ImageIcon background = new ImageIcon("assets/background.jpg");
	private ImageIcon white = new ImageIcon("assets/white_point.png");
	private ImageIcon black = new ImageIcon("assets/black_point.png");
	public ChessManual cm = new ChessManual(this);
	AI1 a;

	public static void main(String[] args) {
		chessBoard ch = new chessBoard();
		ch.initUI();
	}

	private void initUI() {
		JFrame jf = new JFrame();
		jf.setTitle("������");
		jf.setSize(670, 600);
		jf.setLocation(300, 50);
		jf.setDefaultCloseOperation(3);
		ImageIcon icon = new ImageIcon("assets/icon.png");
		jf.setIconImage(icon.getImage());
		jf.setResizable(false);

		// ת��Ϊһ����ǩ����
		JLabel JP = new JLabel(background);
		// �����������
		JP.setBounds(0, 0, jf.getWidth(), jf.getHeight());
		// ��ͼƬ����JLayeredPane������ײ�
		jf.getLayeredPane().add(JP, new Integer(Integer.MIN_VALUE));
		// ��ȡContentPane��壨�����Ǹ���͸���ļһ
		JPanel opacity = (JPanel) jf.getContentPane();
		// ������Ϊ͸����
		opacity.setOpaque(false);

		JPanel jpNorth = panelText();

		jpNorth.setPreferredSize(new Dimension(180, 0));
		jpNorth.setBackground(Color.white);
		jf.add(jpNorth, BorderLayout.EAST);
		jpNorth.setOpaque(false);

		this.setOpaque(false);
		JMenuBar jmb = new JMenuBar();// ��Ӳ˵���
		JMenu file = new JMenu("File");// �½��˵�����
		JMenu jm = new JMenu("Mode");// �½��˵�����
		JMenu jm1 = new JMenu("Version");// �½��˵�����
		jmb.add(jm);// ���˵�������뵽�˵�����
		jmb.add(file);
		jmb.add(jm1);

		CHlistener cl = new CHlistener();

		JMenuItem PP = new JMenuItem("PVP");// �½����˲˵���
		PP.addActionListener(cl);
		jm.add(PP);
		
		JMenuItem HF = new JMenuItem("Human First");// �½����˲˵���
		HF.addActionListener(cl);
		jm.add(HF);

		JMenuItem MF = new JMenuItem("Machine First");// �½����˲˵���
		MF.addActionListener(cl);
		jm.add(MF);

		JMenuItem save = new JMenuItem("Save File");// �½�����˵���
		save.addActionListener(cl);// ��ӵ���ť������
		JMenuItem open = new JMenuItem("Open File");// �½��򿪲˵���
		open.addActionListener(cl);// ��ӵ���ť������
		JMenuItem restart = new JMenuItem("New File");// �½��رղ˵���
		restart.addActionListener(cl);
		file.add(restart);
		file.add(save);
		file.add(open);
		JMenuItem ver = new JMenuItem("1.3");// �½��رղ˵���
		jm1.add(ver);

		jf.add(jmb, BorderLayout.NORTH);
		jf.add(this, BorderLayout.CENTER);

		jf.setVisible(true);

		// ����AI����꣩������
		a = new AI1(this);
		this.addMouseListener(a);
		appendText("��ѡ��ģʽ");
	}

	/**
	 * �����ػ�ķ��� ��д�ػ�ķ��� ÿ����ʾ���嶼���Զ����ô˷���
	 */
	public void paint(Graphics g) {
		super.paint(g);// ���ø���ķ���
		board(g);
		chess(g);
	}

	// �������̵ķ���
	public void board(Graphics g) {
		// g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(),
		// this);
		for (int i = 0; i < data.ROW; i++) {
			g.drawLine(20, 20 + data.SIZE * i, 440, 20 + data.SIZE * i);
		}
		for (int i = 0; i < data.ROW; i++) {
			g.drawLine(20 + data.SIZE * i, 20, 20 + data.SIZE * i, 440);
		}
	}

	// дһ���ػ����ӵķ���
	public void chess(Graphics g) {
		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++) {
				if (data.ARRAY[i][j] == 1) {
					g.drawImage(white.getImage(), 20 + data.SIZE * i
							- data.SIZE / 2,
							20 + data.SIZE * j - data.SIZE / 2, data.SIZE,
							data.SIZE, this);
				}
				if (data.ARRAY[i][j] == 2) {
					g.drawImage(black.getImage(), 20 + data.SIZE * i
							- data.SIZE / 2,
							20 + data.SIZE * j - data.SIZE / 2, data.SIZE,
							data.SIZE, this);
				}
			}
	}

	public void initDATA() {
		for (int i = 0; i < data.ROW; i++)
			for (int j = 0; j < data.COL; j++) {
				data.ARRAY[i][j] = 0;
				data.BOARDSTEP[i][j] = 0;
			}
	}

	private class CHlistener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if (s.equals("Human First")) {
				data.MODOL[0]=1;//�˻�ģʽ
				state = true;
				initDATA();
				repaint();
				appendText("�������");
				File file = new File("index.wzq");
				if(file.exists())
				cm.toArray();
			} else if (s.equals("Machine First")) {
				data.MODOL[0]=1;//�˻�ģʽ
				state = true;
				initDATA();
				// ����������ķ���
				data.ARRAY[7][7] = 2;
				data.BOARDSTEP[7][7] = 1;// ����Ϊ��һ��
				repaint();
				appendText("��������");
				appendText("�ڣ��� " + 8 + " �� " + 8 + " ���� "
						+ data.BOARDSTEP[7][7]);
				File file = new File("index.wzq");
				if(file.exists())
				cm.toArray();
			}
			else if(s.equals("PVP")){
				state = true;
				initDATA();
				repaint();
				data.MODOL[0]=2;//����ģʽ
				appendText("PLAYER VS PLAYER");
			}
		}

	}

	JTextArea jta;
	JScrollPane jsp;

	private JPanel panelText() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setOpaque(false);
		jta = new JTextArea();
		jta.setFont(new Font("΢���ź�", Font.BOLD, 15));
		jsp = new JScrollPane(jta);
		jta.setEditable(false);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jta.setLineWrap(true);// �Զ�����
		jsp.setOpaque(false);
		jta.setOpaque(false);
		jsp.getViewport().setOpaque(false);
		panel.add(jsp);
		return panel;
	}

	// ��ʾ���ķ���
	public void appendText(String str) {
		jta.append(str + "\n");
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				jsp.getVerticalScrollBar().setValue(
						jsp.getVerticalScrollBar().getMaximum());
			}
		});
	}
}
