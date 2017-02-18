package cn.Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * ����̳���������Ϊ�˺���д�ػ�ʱ����
 */
public class chessBoard extends JPanel {
	private static final long serialVersionUID = 1L;

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
		jf.setSize(670, 500);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ImageIcon icon = new ImageIcon("assets/icon.png");
		jf.setIconImage(icon.getImage());
		jf.setLocationRelativeTo(null);
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
		jf.add(this, BorderLayout.CENTER);
		jf.setVisible(true);

		ClientStart cs = new ClientStart(this);
		cs.con2Server();

		// ���루��꣩������
		ChessListener cml = new ChessListener(cs);
		this.addMouseListener(cml);
	}

	/**
	 * �����ػ�ķ��� ��д�ػ�ķ��� ÿ����ʾ���嶼���Զ����ô˷���
	 */
	public void paint(Graphics g) {
		super.paint(g);// ���ø���ķ���
		// �������̵ķ���
		for (int i = 0; i < data.ROW; i++) {
			g.drawLine(20, 20 + data.SIZE * i, 440, 20 + data.SIZE * i);
		}
		for (int i = 0; i < data.ROW; i++) {
			g.drawLine(20 + data.SIZE * i, 20, 20 + data.SIZE * i, 440);
		}
		// дһ���ػ����ӵķ���
		for (int i = 0; i < data.COL; i++)
			for (int j = 0; j < data.ROW; j++) {
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
