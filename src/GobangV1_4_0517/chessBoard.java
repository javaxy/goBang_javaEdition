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
 * 在这继承面板对象是为了后面写重绘时方便
 * 
 * @author Administrator
 * 
 */
public class chessBoard extends JPanel {
	private static final long serialVersionUID = 1L;

	public static boolean state = false;

	// step记录步数
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
		jf.setSize(670, 520);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ImageIcon icon = new ImageIcon("assets/icon.png");
		jf.setIconImage(icon.getImage());
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
		
		Font font = new Font("微软雅黑",Font.BOLD,12);
		JMenuBar jmb = new JMenuBar();// 添加菜单栏
		JMenu file = new JMenu("文件操作");// 新建菜单对象
		file.setFont(font);
		JMenu jm = new JMenu("开始游戏");// 新建菜单对象
		jm.setFont(font);
		JMenu jm1 = new JMenu("版本");// 新建菜单对象
		jm1.setFont(font);
		jmb.add(jm);// 将菜单对象加入到菜单栏里
		jmb.add(file);
		jmb.add(jm1);

		chessListener cl = new chessListener(this);

		
		JMenuItem HF = new JMenuItem("录入棋盘");// 新建人人菜单项
		HF.setFont(font);
		HF.addActionListener(cl);
		jm.add(HF);
		
		JMenuItem read = new JMenuItem("人机对战");// 新建人人菜单项
		read.setFont(font);
		read.addActionListener(cl);
		jm.add(read);

		JMenuItem save = new JMenuItem("保存到文件");// 新建保存菜单项
		save.setFont(font);
		save.addActionListener(cl);// 添加到按钮监听器
		file.add(save);
		JMenuItem delete = new JMenuItem("删除节点");// 新建保存菜单项
		delete.setFont(font);
		delete.addActionListener(cl);// 添加到按钮监听器
		file.add(delete);
		JMenuItem ver = new JMenuItem("1.4");// 新建关闭菜单项
		ver.setFont(font);
		jm1.add(ver);

		jf.add(jmb, BorderLayout.NORTH);
		jf.add(this, BorderLayout.CENTER);

		jf.setVisible(true);
		this.addMouseListener(cl);
	}

	/**
	 * 调用重绘的方法 重写重绘的方法 每次显示窗体都会自动调用此方法
	 */
	public void paint(Graphics g) {
		super.paint(g);// 调用父类的方法
		board(g);
		chess(g);
	}

	// 绘制棋盘的方法
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

	// 写一个重绘棋子的方法
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
