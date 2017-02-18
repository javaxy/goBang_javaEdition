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
 * 在这继承面板对象是为了后面写重绘时方便
 * 
 * @author 徐意
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
	public ChessManual cm = new ChessManual(this);
	AI1 a;

	public static void main(String[] args) {
		chessBoard ch = new chessBoard();
		ch.initUI();
	}

	private void initUI() {
		JFrame jf = new JFrame();
		jf.setTitle("五子棋");
		jf.setSize(670, 600);
		jf.setLocation(300, 50);
		jf.setDefaultCloseOperation(3);
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
		JMenuBar jmb = new JMenuBar();// 添加菜单栏
		JMenu file = new JMenu("File");// 新建菜单对象
		JMenu jm = new JMenu("Mode");// 新建菜单对象
		JMenu jm1 = new JMenu("Version");// 新建菜单对象
		jmb.add(jm);// 将菜单对象加入到菜单栏里
		jmb.add(file);
		jmb.add(jm1);

		CHlistener cl = new CHlistener();

		JMenuItem PP = new JMenuItem("PVP");// 新建人人菜单项
		PP.addActionListener(cl);
		jm.add(PP);
		
		JMenuItem HF = new JMenuItem("Human First");// 新建人人菜单项
		HF.addActionListener(cl);
		jm.add(HF);

		JMenuItem MF = new JMenuItem("Machine First");// 新建人人菜单项
		MF.addActionListener(cl);
		jm.add(MF);

		JMenuItem save = new JMenuItem("Save File");// 新建保存菜单项
		save.addActionListener(cl);// 添加到按钮监听器
		JMenuItem open = new JMenuItem("Open File");// 新建打开菜单项
		open.addActionListener(cl);// 添加到按钮监听器
		JMenuItem restart = new JMenuItem("New File");// 新建关闭菜单项
		restart.addActionListener(cl);
		file.add(restart);
		file.add(save);
		file.add(open);
		JMenuItem ver = new JMenuItem("1.3");// 新建关闭菜单项
		jm1.add(ver);

		jf.add(jmb, BorderLayout.NORTH);
		jf.add(this, BorderLayout.CENTER);

		jf.setVisible(true);

		// 加入AI（鼠标）监听器
		a = new AI1(this);
		this.addMouseListener(a);
		appendText("请选择模式");
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
				data.MODOL[0]=1;//人机模式
				state = true;
				initDATA();
				repaint();
				appendText("玩家先手");
				File file = new File("index.wzq");
				if(file.exists())
				cm.toArray();
			} else if (s.equals("Machine First")) {
				data.MODOL[0]=1;//人机模式
				state = true;
				initDATA();
				// 电脑先下棋的方法
				data.ARRAY[7][7] = 2;
				data.BOARDSTEP[7][7] = 1;// 记下为第一步
				repaint();
				appendText("电脑先手");
				appendText("黑：横 " + 8 + " 竖 " + 8 + " 步数 "
						+ data.BOARDSTEP[7][7]);
				File file = new File("index.wzq");
				if(file.exists())
				cm.toArray();
			}
			else if(s.equals("PVP")){
				state = true;
				initDATA();
				repaint();
				data.MODOL[0]=2;//人人模式
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
