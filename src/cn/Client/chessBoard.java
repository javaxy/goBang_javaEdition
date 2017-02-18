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
 * 在这继承面板对象是为了后面写重绘时方便
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
		jf.setTitle("五子棋");
		jf.setSize(670, 500);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ImageIcon icon = new ImageIcon("assets/icon.png");
		jf.setIconImage(icon.getImage());
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);

		// 转换为一个标签对象
		JLabel JP = new JLabel(background);
		// 设置填充区域
		JP.setBounds(0, 0, jf.getWidth(), jf.getHeight());
		// 将图片置于JLayeredPane面板的最底层
		jf.getLayeredPane().add(JP, new Integer(Integer.MIN_VALUE));
		// 获取ContentPane面板（就是那个不透明的家伙）
		JPanel opacity = (JPanel) jf.getContentPane();
		// 把它设为透明的
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

		// 加入（鼠标）监听器
		ChessListener cml = new ChessListener(cs);
		this.addMouseListener(cml);
	}

	/**
	 * 调用重绘的方法 重写重绘的方法 每次显示窗体都会自动调用此方法
	 */
	public void paint(Graphics g) {
		super.paint(g);// 调用父类的方法
		// 绘制棋盘的方法
		for (int i = 0; i < data.ROW; i++) {
			g.drawLine(20, 20 + data.SIZE * i, 440, 20 + data.SIZE * i);
		}
		for (int i = 0; i < data.ROW; i++) {
			g.drawLine(20 + data.SIZE * i, 20, 20 + data.SIZE * i, 440);
		}
		// 写一个重绘棋子的方法
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
		jta.setFont(new Font("微软雅黑", Font.BOLD, 15));
		jsp = new JScrollPane(jta);
		jta.setEditable(false);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jta.setLineWrap(true);// 自动换行
		jsp.setOpaque(false);
		jta.setOpaque(false);
		jsp.getViewport().setOpaque(false);
		panel.add(jsp);
		return panel;
	}

	// 显示屏的方法
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
