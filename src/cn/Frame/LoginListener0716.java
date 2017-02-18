package cn.Frame;

/**
 * JRadioButton 单选按钮
 */
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 * 适配器就是抽象类 MouseAdapter重写了mouselistener中的所有方法，所以你不用全部实现 你只需要重写你所需要的方法
 * 
 * @author Administrator
 * 
 */
public class LoginListener0716 extends MouseAdapter implements ActionListener {
	private String pass, name;
	private JPasswordField jp1;
	private JComboBox co;
	private JFrame qqf;
	// private JButton j5;
	Point P;
	Point orgin = new Point();

	// 得到关闭按钮的位置
	// Point pj=j5.getLocation();

	// 重写她的构造方法，用于传递登陆界面的用户名和密码的值
	public LoginListener0716(JFrame qqf) {
		this.qqf = qqf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 判断动作执行的对象是否是JButton的实例化的一个对象
		if (e.getSource() instanceof JButton) {
			// System.out.println("fffffffff");
			// 打印出按钮的命令
			System.out.println(e.getActionCommand());
			// 判断按钮的命令作用
			if (e.getActionCommand().equals("close")) {
				System.exit(0);
			}

			// 如果得到的是网络通信
			if (e.getActionCommand().equals("pvp")) {
				new startServer().start();
				new startClient().start();
			}

			if (e.getActionCommand().equals("pve")) {
                  new GobangV1_4_0517.chessBoard().initUI();
			}
			if (e.getActionCommand().equals("eve")) {
				cn.AI2AI.chessBoard eve = new cn.AI2AI.chessBoard();
				eve.initUI();
			}
		}
	}

	// 得到最原始的坐标
	public void mousePressed(MouseEvent e) {
		orgin.x = e.getX();
		orgin.y = e.getY();
		// System.out.print(orgin.x); System.out.println(orgin.y);
	}

	// 设置一个拖动事件
	public void mouseDragged(MouseEvent e) {
		// 获取绝对位置
		Point P1 = qqf.getLocation();
		// 重新设置面板位置
		qqf.setLocation(P1.x + e.getX() - orgin.x, P1.y + e.getY() - orgin.y);
		// qqf.setLocation(e.getX(),e.getY());
	}
}

class startServer extends Thread {

	public void run() {
		new cn.Server.ServerStart(9999);
	}

}

class startClient extends Thread{
	public void run(){
		try {
			Thread.sleep(1000);
			new cn.Client.chessBoard().initUI();
			Thread.sleep(1000);
			new cn.Client.chessBoard().initUI();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}