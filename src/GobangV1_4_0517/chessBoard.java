package GobangV1_4_0517;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

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
 * @author Administrator
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

	public static void main(String[] args) {
		chessBoard ch = new chessBoard();
		ch.initUI();
	}

	public void initUI() {
		JFrame jf = new JFrame();
		jf.setTitle("������");
		jf.setSize(670, 520);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		Font font = new Font("΢���ź�",Font.BOLD,12);
		JMenuBar jmb = new JMenuBar();// ��Ӳ˵���
		JMenu file = new JMenu("�ļ�����");// �½��˵�����
		file.setFont(font);
		JMenu jm = new JMenu("��ʼ��Ϸ");// �½��˵�����
		jm.setFont(font);
		JMenu jm1 = new JMenu("�汾");// �½��˵�����
		jm1.setFont(font);
		jmb.add(jm);// ���˵�������뵽�˵�����
		jmb.add(file);
		jmb.add(jm1);

		chessListener cl = new chessListener(this);

		
		JMenuItem HF = new JMenuItem("¼������");// �½����˲˵���
		HF.setFont(font);
		HF.addActionListener(cl);
		jm.add(HF);
		
		JMenuItem read = new JMenuItem("�˻���ս");// �½����˲˵���
		read.setFont(font);
		read.addActionListener(cl);
		jm.add(read);

		JMenuItem save = new JMenuItem("���浽�ļ�");// �½�����˵���
		save.setFont(font);
		save.addActionListener(cl);// ��ӵ���ť������
		file.add(save);
		JMenuItem delete = new JMenuItem("ɾ���ڵ�");// �½�����˵���
		delete.setFont(font);
		delete.addActionListener(cl);// ��ӵ���ť������
		file.add(delete);
		JMenuItem ver = new JMenuItem("1.4");// �½��رղ˵���
		ver.setFont(font);
		jm1.add(ver);

		jf.add(jmb, BorderLayout.NORTH);
		jf.add(this, BorderLayout.CENTER);

		jf.setVisible(true);
		this.addMouseListener(cl);
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
				if (data.ARRAY[i][j] == 2) {
					g.drawImage(white.getImage(), 20 + data.SIZE * i
							- data.SIZE / 2,
							20 + data.SIZE * j - data.SIZE / 2, data.SIZE,
							data.SIZE, this);
				}
				if (data.ARRAY[i][j] == 1) {
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
